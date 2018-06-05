package io.khasang.rtrail.controller;

import io.khasang.rtrail.entity.Cat;
import org.junit.*;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import java.util.List;

import java.awt.*;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CatControllerIntegrationTest {

    private static final String ROOT = "http://localhost:8080/cat";
    private static final String ADD = "/add";
    private static final String GET = "/get";
    private static final String ALL = "/all";
    private static final String DELETE = "/delete";
    private static final String UPDATE = "/update";


    @Before
    public void init(){
        System.out.println("Init");
    }

    @BeforeClass
    public static void globalInit(){
        System.out.println("Global init");
    }

    @Test
    public void addCat(){
        Cat cat = createdCat();

        RestTemplate template = new RestTemplate();

        ResponseEntity<Cat> responseEntity = template.exchange(
                ROOT + GET + "/{id}",
                HttpMethod.GET,
                null,
                Cat.class,
                cat.getId()
        );
        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Cat recievedCat = responseEntity.getBody();
        assertNotNull(recievedCat);
        assertEquals(cat.getId(), recievedCat.getId());
        assertNotNull(recievedCat.getDescription());
    }

    @Test
    public void getAllCat(){
        createdCat();
        createdCat();
        RestTemplate template = new RestTemplate();
        ResponseEntity<List<Cat>> responseEntity = template.exchange(
                ROOT + GET +ALL,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<Cat>>(){
                    }
        );

        List<Cat> catList = responseEntity.getBody();
        assertNotNull(catList.get(0));
        assertNotNull(catList.get(1));
    }

    @Test
    public void updateCat(){
        Cat cat = createdCat();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        cat.setDescription("UpdatedCat");
        HttpEntity<Cat> httpEntity = new HttpEntity<>(cat, headers);
        RestTemplate template = new RestTemplate();
        Cat updatedCat = template.exchange(
                ROOT + UPDATE,
                    HttpMethod.PUT,
                    httpEntity,
                    Cat.class
                ).getBody();

        assertNotNull(updatedCat);
        assertEquals("UpdatedCat", updatedCat.getDescription());
    }

    @Test
    public void deleteCat(){
        Cat cat = createdCat();

        RestTemplate template = new RestTemplate();
        ResponseEntity<Cat> responseEntity = template.exchange(
                ROOT + DELETE +"/?id={id}",
                HttpMethod.DELETE,
                null,
                Cat.class,
                cat.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Cat deletedCat = responseEntity.getBody();
        assertNotNull(deletedCat.getName());
        ResponseEntity<Cat> responseForDeleteCat = template.exchange(
                ROOT +GET +"/{id}",
                HttpMethod.GET,
                null,
                Cat.class,
                deletedCat.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        assertNull(responseForDeleteCat.getBody());
    }


    private Cat createdCat(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Cat cat = prefillCat("Chernish");
        HttpEntity<Cat> httpEntity = new HttpEntity<>(cat, headers);
        RestTemplate template = new RestTemplate();
        Cat createdCat = template.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                httpEntity,
                Cat.class
        ).getBody();

        assertNotNull(createdCat);
        assertEquals(cat.getName(), createdCat.getName());
        return createdCat;
    }

    private Cat prefillCat(String name) {
        Cat cat = new Cat();
        cat.setName(name);
        cat.setDescription("funny");
        return cat;
    }


    @After
    public void clean(){
        System.out.println("Clean");
    }

    @AfterClass
    public static void globalClean(){
        System.out.println("Global Clean");
    }
}
