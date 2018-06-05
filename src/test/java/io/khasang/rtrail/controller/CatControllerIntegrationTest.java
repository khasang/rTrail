package io.khasang.rtrail.controller;

import io.khasang.rtrail.dao.CatDao;
import io.khasang.rtrail.entity.Cat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.*;

public class CatControllerIntegrationTest {

    private static final String ROOT = "http://localhost:8080/cat";
    private static final String ADD = "/add";
    private static final String GET = "/get";
    private static final String DELETE = "/delete";
    private static final String ALL = "/get/all";
    private static final String UPDATE = "/update";

    @Before
    public void init() {

    }

    @After
    public void cleanUp() {

    }

    @Test
    public void checkAddCatAndGet() {
        Cat cat = createCat();

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
    }

    @Test
    public void checkAllCats() {
        // clean
        createCat();
        createCat();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Cat>> responseEntity = restTemplate.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Cat>>() {
                }
        );

        List<Cat> cats = responseEntity.getBody();
        assertNotNull(cats.get(0));
        assertNotNull(cats.get(1));

        // clean
    }
    //---------
    @Test
    public void updateCat() {

        String newCatName = "Murzik";
        String newCatDescription = "angry";

        Cat cat = createCat();

        assertNotEquals(newCatName, cat.getName());
        assertNotEquals(newCatDescription, cat.getDescription());

        cat.setName(newCatName);
        cat.setDescription(newCatDescription);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<Cat> httpEntity = new HttpEntity<>(cat, headers);

        RestTemplate template = new RestTemplate();
        ResponseEntity<Cat> responseEntity = template.exchange(
                ROOT + UPDATE,
                HttpMethod.PUT,
                httpEntity,
                Cat.class
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Cat receivedCat = responseEntity.getBody();
        assertNotNull(receivedCat);
        assertEquals(newCatName, receivedCat.getName());
        assertEquals(newCatDescription, receivedCat.getDescription());
    }

    //----------------
    @Test
    public void deleteCat() {
        Cat cat = createCat();

        RestTemplate template = new RestTemplate();
        ResponseEntity<Cat> responseEntity = template.exchange(
                ROOT + DELETE + "/{id}",
                HttpMethod.DELETE,
                null,
                Cat.class,
                cat.getId()
        );
        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());

        Cat deletedCat = responseEntity.getBody();
        assertNotNull(deletedCat.getName());

        ResponseEntity<Cat> responseForDeleteCat = template.exchange(
                ROOT + GET + "/{id}",
                HttpMethod.GET,
                null,
                Cat.class,
                deletedCat.getId()
        );

        assertEquals("OK", responseForDeleteCat.getStatusCode().getReasonPhrase());
        assertNull(responseForDeleteCat.getBody());
    }
    //---------
    private Cat createCat() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Cat cat = prefillCat("Mursik");

        HttpEntity<Cat> httpEntity = new HttpEntity<>(cat, headers);
        RestTemplate template = new RestTemplate();

        Cat createdCat = template.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                httpEntity,
                Cat.class
        ).getBody();

        assertEquals(cat.getName(), createdCat.getName());
        assertNotNull(createdCat.getId());
        return createdCat;
    }

    private Cat prefillCat(String name) {
        Cat cat = new Cat();
        cat.setName(name);
        cat.setDescription("hungry");

        return cat;
    }
}