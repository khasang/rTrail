package io.khasang.rtrail.controller;

import io.khasang.rtrail.entity.Rout;
import org.junit.Test;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RoutControllerIntegrationTest {

    private final static String ROOT = "http://localhost:8080/rout";
    private final static String ADD = "/add";
    private final static String GET = "/get";
    private final static String DELETE = "/delete";
    private final static String UPDATE = "/update";

    @Test
    public void checkAddRoutAndGet() {
        Rout rout = createRout();

        RestTemplate template = new RestTemplate();
        ResponseEntity<Rout> responseEntity = template.exchange(
                ROOT + GET + "/{id}",
                HttpMethod.GET,
                null,
                Rout.class,
                rout.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());

        Rout receivedRout = responseEntity.getBody();
        assertNotNull(receivedRout);
    }

    private Rout createRout() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Rout rout = prefillRout("new rout");

        HttpEntity<Rout> httpEntity = new HttpEntity<>(rout, headers);
        RestTemplate template = new RestTemplate();

        Rout createdRout = template.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                httpEntity,
                Rout.class
        ).getBody();

        assertEquals(rout.getName(), createdRout.getName());
        assertNotNull(createdRout.getId());
        return createdRout;
    }

    private Rout prefillRout(String name) {
        Rout rout = new Rout();
        rout.setName(name);
        rout.setDescription("new rout description");
        return rout;
    }
}
