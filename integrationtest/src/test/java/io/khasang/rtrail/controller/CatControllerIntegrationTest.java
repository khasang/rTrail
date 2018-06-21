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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CatControllerIntegrationTest {

    private final static String ROOT = "http://localhost:8080/cat";
    private final static String ADD = "/add";
    private final static String ALL = "/all";
    private final static String GET_BY_ID = "/get";

    @Before
    public void init() {

    }

    @After
    public void cleanUp() {

    }

    @Test
    public void checkAddCatAndGet() {
        CatDTO cat = createCat();

        RestTemplate template = new RestTemplate();
        ResponseEntity<CatDTO> responseEntity = template.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                CatDTO.class,
                cat.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());

        CatDTO recievedCat = responseEntity.getBody();
        assertNotNull(recievedCat);
    }

    @Test
    public void checkAllCats() {
        // clean
        createCat();
        createCat();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Cat>> responseEntity = restTemplate.exchange(
                ROOT + GET_BY_ID + ALL,
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

    private CatDTO createCat() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Cat cat = prefillCat("Mursik");

        HttpEntity<Cat> httpEntity = new HttpEntity<>(cat, headers);
        RestTemplate template = new RestTemplate();

        CatDTO createdCat = template.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                httpEntity,
                CatDTO.class
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
