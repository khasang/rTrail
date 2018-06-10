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

public class AuthorControllerIntegrationTest {

    private final static String ROOT = "http://localhost:8080/author";
    private final static String ADD = "/add";
    private final static String ALL = "/all";
    private final static String UPDATE = "/update";
    private final static String DELETE = "/delete";
    private final static String GET = "/get";

    @Test
    public void checkAddUserAndGet() {
        Author author = createAuthor();

        RestTemplate template = new RestTemplate();
        ResponseEntity<Author> responseEntity = template.exchange(
                ROOT + GET + "/{id}",
                HttpMethod.GET,
                null,
                Author.class,
                author.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Author receivedAuthor = responseEntity.getBody();
        assertEquals(author.getAuthorName(), receivedAuthor.getAuthorName());
        assertNotNull(receivedAuthor);
        removeAuthorFromDao(receivedAuthor);
    }

    @Test
    public void checkAllAuthor() {
        Author author1 = createAuthor();
        Author author2 = createAuthor();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Author>> responseEntity = restTemplate.exchange(
                ROOT + GET + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Author>>() {
                }
        );

        List<Author> authorList = responseEntity.getBody();
        assertNotNull(authorList.get(0));
        assertNotNull(authorList.get(1));
        removeAuthorFromDao(author1);
        removeAuthorFromDao(author2);
    }

    @Test
    public void checkUpdateAuthor() {
        Author author = createAuthor();
        author.setTypeOfBooks("Comedy");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        HttpEntity<Author> httpEntity = new HttpEntity<>(author, headers);
        RestTemplate template = new RestTemplate();

        Author updatedAuthor = template.exchange(
                ROOT + UPDATE,
                HttpMethod.PUT,
                httpEntity,
                Author.class
        ).getBody();

        assertEquals(author.getTypeOfBooks(), updatedAuthor.getTypeOfBooks());
        assertNotNull(updatedAuthor.getId());

        removeAuthorFromDao(updatedAuthor);
    }

    @Test
    public void checkDeleteAuthor() {
        Author author = createAuthor();

        RestTemplate template = new RestTemplate();

        ResponseEntity<Author> deletedAuthor = template.exchange(
                ROOT + DELETE + "?id={id}",
                HttpMethod.DELETE,
                null,
                Author.class,
                author.getId()
        );

        assertNotNull(deletedAuthor.getBody());
    }

    private Author createAuthor() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        Book book1 = new Book();
        book1.setBookname("King Leer");
        Book book2 = new Book();
        book2.setBookname("Gamlet");
        List <Book> bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);
        Author author = prefillAuthor("Shekspir", "Tragedy", bookList);

        HttpEntity<Author> httpEntity = new HttpEntity<>(author, headers);
        RestTemplate template = new RestTemplate();

        Author createdAuthor = template.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                httpEntity,
                Author.class
        ).getBody();

        assertEquals(author.getAuthorName(), createdAuthor.getAuthorName());
        assertNotNull(createdAuthor.getId());
        return createdAuthor;
    }

    private Author prefillAuthor(String authorName, String typeOfBook, List<Book> bookList) {
        Author author = new Author();
        author.setAuthorName(authorName);
        author.setTypeOfBooks(typeOfBook);
        author.setBookList(bookList);
        return author;
    }

    private void removeAuthorFromDao(Author author){
        RestTemplate template = new RestTemplate();
        template.exchange(
                ROOT + DELETE + "?id={id}",
                HttpMethod.DELETE,
                null,
                Author.class,
                author.getId()
        );
    }
}

