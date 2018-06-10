package io.khasang.rtrail.controller;

import io.khasang.rtrail.entity.CheckPoint;
import io.khasang.rtrail.entity.Rout;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RoutControllerIntegrationTest {

    private final static String ROOT = "http://localhost:8080/rout";
    private final static String ADD = "/add";
    private final static String GET = "/get";
    private final static String GET_BY_NAME = "/get/name";
    private final static String GET_BY_OWNER = "/get/routByOwner";
    private final static String DELETE = "/delete";
    private final static String UPDATE = "/update";
    private final static String GET_ALL = "/get/all";

    @Test
    public void checkAddRoutAndGet() {
        Rout rout = createRout("rout", "owner");
        Rout routFromDb = getRoutById(rout.getId());

        assertNotNull(routFromDb);
    }

    @Test
    public void checkDeleteRout() {
        Rout rout = createRout("rout", "owner");

        RestTemplate template = new RestTemplate();
        ResponseEntity<Rout> responseEntity = template.exchange(
                ROOT + DELETE + "/{id}",
                HttpMethod.DELETE,
                null,
                Rout.class,
                rout.getId()
        );
        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());

        Rout receivedRout = getRoutById(rout.getId());
        assertNull(receivedRout);

    }

    @Test
    public void checkUpdateRout() {
        Rout routToUpdate = createRout("rout", "owner");
        Rout newRout = preFillRout("rout updated", "new owner");
        newRout.setId(routToUpdate.getId());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<Rout> httpEntity = new HttpEntity<>(newRout, headers);
        RestTemplate template = new RestTemplate();

        Rout updatedRout = template.exchange(
                ROOT + UPDATE,
                HttpMethod.PUT,
                httpEntity,
                Rout.class
        ).getBody();

        assertEquals(newRout.getName(), updatedRout.getName());
    }

    @Test
    public void checkGetAllRouts() {
        Rout rout = createRout("rout name", "owner");

        RestTemplate template = new RestTemplate();
        ResponseEntity<List<Rout>> responseEntity = template.exchange(
                ROOT + GET_ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Rout>>() {
                }
        );
        List<Rout> routList = responseEntity.getBody();
        boolean result = false;
        for (Rout routCheck : routList) {
            if (routCheck.getId().equals(rout.getId())) {
                result = true;
            }
        }
        assertTrue(result);
    }

    @Test
    public void checkGetRoutByName() {
        Rout rout = createRout("routToFindByName", "owner");

        RestTemplate template = new RestTemplate();
        ResponseEntity<List<Rout>> responseEntity = template.exchange(
                ROOT + GET_BY_NAME + "/{name}",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Rout>>() {
                },
                rout.getName()
        );
        List<Rout> routList = responseEntity.getBody();
        boolean result = false;
        for (Rout routCheck : routList) {
            if (routCheck.getName().equals(rout.getName())) {
                result = true;
            } else {
                result = false;
                break;
            }
        }
        assertTrue(result);
    }

    @Test
    public void checkGetRoutByOwner() {
        Rout rout = createRout("routToFind", "new owner");

        RestTemplate template = new RestTemplate();
        ResponseEntity<List<Rout>> responseEntity = template.exchange(
                ROOT + GET_BY_OWNER + "/{owner}",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Rout>>() {
                },
                rout.getOwner()
        );
        List<Rout> routList = responseEntity.getBody();
        boolean result = false;
        for (Rout routCheck : routList) {
            if (routCheck.getOwner().equals(rout.getOwner())) {
                result = true;
            } else {
                result = false;
                break;
            }
        }
        assertTrue(result);
    }

    private Rout createRout(String name, String owner) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Rout rout = preFillRout(name, owner);

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

    private Rout getRoutById(long id) {
        RestTemplate template = new RestTemplate();
        ResponseEntity<Rout> responseEntity = template.exchange(
                ROOT + GET + "/{id}",
                HttpMethod.GET,
                null,
                Rout.class,
                id
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());

        return responseEntity.getBody();
    }

    private Rout preFillRout(String name, String owner) {
        Rout rout = new Rout();
        rout.setName(name);
        rout.setOwner(owner);
        rout.setDescription("test rout");
        CheckPoint point1 = new CheckPoint();
        CheckPoint point2 = new CheckPoint();
        point1.setCoordX(1L);
        point1.setCoordY(2L);
        point2.setCoordX(4L);
        point2.setCoordY(3L);
        List<CheckPoint> checkPoints = new ArrayList<>();
        checkPoints.add(point1);
        checkPoints.add(point2);
        rout.setCheckPointList(checkPoints);
        return rout;
    }
}
