package io.khasang.rtrail.controller;

import io.khasang.rtrail.entity.Author;
import io.khasang.rtrail.entity.Book;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BookControllerIntegrationTest {

    private final static String ROOT = "http://localhost:8080/book";
    private final static String ADD = "/add";
    private final static String ALL = "/all";
    private final static String UPDATE = "/update";
    private final static String DELETE = "/delete";
    private final static String GET = "/get";

    @Test
    public void checkAddBookAndGet() {
        Book book = createBook();

        RestTemplate template = new RestTemplate();
        ResponseEntity<Book> responseEntity = template.exchange(
                ROOT + GET + "/{id}",
                HttpMethod.GET,
                null,
                Book.class,
                book.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Book receivedBook = responseEntity.getBody();
        assertEquals(book.getBookname(), receivedBook.getBookname());
        assertNotNull(receivedBook);
        removeBookFromDao(receivedBook);
    }

    @Test
    public void checkAllBooks() {
        Book book1 = createBook();
        Book book2 = createBook();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Book>> responseEntity = restTemplate.exchange(
                ROOT + GET + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Book>>() {
                }
        );

        List<Book> bookList = responseEntity.getBody();
        assertNotNull(bookList.get(0));
        assertNotNull(bookList.get(1));
        removeBookFromDao(book1);
        removeBookFromDao(book2);
    }

    @Test
    public void checkUpdateBook() {
        Book book = createBook();
        book.setBookname("The very last story");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        HttpEntity<Book> httpEntity = new HttpEntity<>(book, headers);
        RestTemplate template = new RestTemplate();

        Book updatedBook = template.exchange(
                ROOT + UPDATE,
                HttpMethod.PUT,
                httpEntity,
                Book.class
        ).getBody();

        assertEquals(book.getBookname(), updatedBook.getBookname());
        assertNotNull(updatedBook.getId());

        removeBookFromDao(updatedBook);
    }

    @Test
    public void checkDeleteBook() {
        Book book = createBook();

        RestTemplate template = new RestTemplate();

        ResponseEntity<Book> deletedBook = template.exchange(
                ROOT + DELETE + "?id={id}",
                HttpMethod.DELETE,
                null,
                Book.class,
                book.getId()
        );

        assertNotNull(deletedBook.getBody());
    }

    private Book createBook() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        Author author1 = new Author();
        author1.setAuthorName("Goncharov");
        Author author2 = new Author();
        author2.setAuthorName("Bastakov");
        List <Author> authorList = new ArrayList<>();
        authorList.add(author1);
        authorList.add(author2);
        Book book = prefillBook("The last one story", "2020", authorList);

        HttpEntity<Book> httpEntity = new HttpEntity<>(book, headers);
        RestTemplate template = new RestTemplate();

        Book createdBook = template.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                httpEntity,
                Book.class
        ).getBody();

        assertEquals(book.getBookname(), createdBook.getBookname());
        assertNotNull(createdBook.getId());
        return createdBook;
    }

    private Book prefillBook(String bookname, String issueYear, List<Author> authorList) {
        Book book = new Book();
        book.setBookname(bookname);
        book.setIssueYear(issueYear);
        book.setAuthorList(authorList);
        return book;
    }

    private void removeBookFromDao(Book book){
        RestTemplate template = new RestTemplate();
        template.exchange(
                ROOT + DELETE + "?id={id}",
                HttpMethod.DELETE,
                null,
                Book.class,
                book.getId()
        );
    }
}
