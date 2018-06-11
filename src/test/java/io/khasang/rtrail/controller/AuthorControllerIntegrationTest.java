package io.khasang.rtrail.controller;

import io.khasang.rtrail.dto.AuthorDTO;
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

public class AuthorControllerIntegrationTest {
    private static final String ROOT = "http://localhost:8080/author";
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
    public void checkAddBookAndAuthor() {
        Author author = createdAuthor();

        RestTemplate template = new RestTemplate();
        ResponseEntity<AuthorDTO> responseEntity = template.exchange(
                ROOT + GET + "/{id}",
                HttpMethod.GET,
                null,
                AuthorDTO.class,
                author.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        AuthorDTO receivedAuthor = responseEntity.getBody();
        assertNotNull(receivedAuthor);
        assertNotNull(receivedAuthor.getFirstName());
        assertNotNull(receivedAuthor.getLastName());
        assertEquals(author.getId(), receivedAuthor.getId());
    }

    private Author createdAuthor() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Author author = prefillAuthor("Ken", "Kesey");

        HttpEntity<Author> httpEntity = new HttpEntity<>(author, headers);
        RestTemplate template = new RestTemplate();
        Author createdAuthor = template.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                httpEntity,
                Author.class
        ).getBody();

        assertNotNull(createdAuthor);
        assertEquals(author.getFirstName(), createdAuthor.getFirstName());
        assertEquals(author.getLastName(), createdAuthor.getLastName());
        return createdAuthor;
    }

    private Author prefillAuthor(String firstName, String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);

        Book book1 = new Book();
        Book book2 = new Book();

        book1.setName("One Flew Over the Cuckoo's Nest");
        book1.setGenre("allegory");
        book2.setName("Sometimes a Great Notion");
        book2.setGenre("novel");

        List<Book> bookList = new ArrayList<>(Arrays.asList(book1, book2));

        author.setBookList(bookList);

        return author;
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
