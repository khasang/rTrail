package io.khasang.rtrail.controller;

import io.khasang.rtrail.entity.Author;
import io.khasang.rtrail.entity.Book;
import org.junit.*;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BookControllerIntegrationTest {
    private static final String ROOT = "http://localhost:8080/book";
    private static final String ADD = "/add";
    private static final String GET = "/get";

    @Before
    public void init() {
        System.out.println("init");
    }

    @BeforeClass
    public static void globalInit() {
        System.out.println("global init");
    }

    @Test
    public void addBook() {
        Book book = createdBook();

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
        assertNotNull(receivedBook);
        assertNotNull(receivedBook.getName());
        assertNotNull(receivedBook.getGenre());
        assertEquals(book.getId(), receivedBook.getId());
    }

    private Book createdBook() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Book book = prefillBook("Petroleum Reservoir Fluid Property Correlations", "Science");

        HttpEntity<Book> httpEntity = new HttpEntity<>(book, headers);
        RestTemplate template = new RestTemplate();
        Book createdBook = template.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                httpEntity,
                Book.class
        ).getBody();

        assertNotNull(createdBook);
        assertEquals(book.getName(), createdBook.getName());
        assertEquals(book.getGenre(), createdBook.getGenre());
        return createdBook;
    }

    private Book prefillBook(String name, String genre) {
        Book book = new Book();
        book.setName(name);
        book.setGenre(genre);

        Author author1 = new Author();
        Author author2 = new Author();

        author1.setFirstName("William");
        author1.setLastName("McCain");
        author2.setFirstName("John");
        author2.setLastName("Spivey");

        List<Author> authorList = new ArrayList<>(Arrays.asList(author1, author2));

        book.setAuthorList(authorList);

        return book;
    }

    @After
    public void clean() {
        System.out.println("clean");
    }

    @AfterClass
    public static void globalClean() {
        System.out.println("global clean");
    }
}
