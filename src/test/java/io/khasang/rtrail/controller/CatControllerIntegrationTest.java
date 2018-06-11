package io.khasang.rtrail.controller;

//import static org.junit.Assert.*;

import io.khasang.rtrail.dto.CatDTO;
import io.khasang.rtrail.entity.Cat;
import org.junit.*;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import sun.security.x509.CertAttrSet;

import java.util.List;

import static org.junit.Assert.*;

public class CatControllerIntegrationTest {

    private static final String ROOT = "http://localhost:8080/cat";
    private static final String ADD = "/add";
    private static final String GET_BY_ID = "/get";
    private static final String DELETE = "/delete";
    private static final String ALL = "/all";
    private static final String UPDATE = "/update";

    @Before
    public void init() {
        System.out.println("init");
    }

    @BeforeClass
    public static void globalInit() {
        System.out.println("Global init");
    }


    //    @Test(expected = RuntimeException.class)
//    @Test(timeout = 1000)
    @Test
    public void addCat() {
        CatDTO cat = createdCat();

        RestTemplate template = new RestTemplate();

        ResponseEntity<CatDTO> responseEntity = template.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                CatDTO.class,
                cat.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        CatDTO receivedCat = responseEntity.getBody();
        assertNotNull(receivedCat);
        assertEquals(cat.getId(), receivedCat.getId());
        assertNotNull(receivedCat.getDescription());
    }

    @Test
    public void checkAllCats() {
        // clean

        createdCat();
        createdCat();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Cat>> responseEntity = restTemplate.exchange(
                ROOT + GET_BY_ID + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Cat>>() {
                }
        );

        List<Cat> employees = responseEntity.getBody();
        assertNotNull(employees.get(0));
        assertNotNull(employees.get(1));

        // clean
    }

    @Test
    public void updateCat() {

        CatDTO cat = createdCat();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        cat.setName("New Name");
        cat.setDescription("New Description");

        CatDTO catDTO = new CatDTO();

        HttpEntity<Cat> httpEntity = new HttpEntity<>(catDTO.getCat(cat), headers);
        RestTemplate template = new RestTemplate();

        CatDTO updatedCat = template.exchange(
                ROOT + UPDATE,
                HttpMethod.PUT,
                httpEntity,
                CatDTO.class
        ).getBody();

        ResponseEntity<CatDTO> responseEntity = template.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                CatDTO.class,
                updatedCat.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());

        CatDTO recievedCat = responseEntity.getBody();
        assertNotNull(recievedCat);
        assertEquals("New Name", recievedCat.getName());
        assertEquals("New Description", recievedCat.getDescription());
    }


    @Test
    public void deleteCat() {
        CatDTO cat = createdCat();

        RestTemplate template = new RestTemplate();
        ResponseEntity<CatDTO> responseEntity = template.exchange(
                ROOT + DELETE + "/?id={id}",
                HttpMethod.DELETE,
                null,
                CatDTO.class,
                cat.getId()
        );
        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());

        CatDTO deletedCat = responseEntity.getBody();
        assertNotNull(deletedCat.getName());

        ResponseEntity<Cat> responseForDeleteCat = template.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                Cat.class,
                deletedCat.getId()
        );

        assertEquals("OK", responseForDeleteCat.getStatusCode().getReasonPhrase());
        assertNull(responseForDeleteCat.getBody());
    }

    private CatDTO createdCat() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Cat cat = prefillCat("Barsik");

        HttpEntity<Cat> httpEntity = new HttpEntity<>(cat, headers);

        RestTemplate template = new RestTemplate();
        CatDTO createdCat = template.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                httpEntity,
                CatDTO.class
        ).getBody();

        assertNotNull(createdCat);
        assertEquals(cat.getName(), createdCat.getName());
        return createdCat;
    }

    private Cat prefillCat(String barsik) {
        Cat cat = new Cat();
        cat.setName(barsik);
        cat.setDescription("happy");
        return cat;
    }

    @After
    public void clean() {
        System.out.println("Clean");
    }

    @AfterClass
    public static void globalClean() {
        System.out.println("Global clean");
    }

}