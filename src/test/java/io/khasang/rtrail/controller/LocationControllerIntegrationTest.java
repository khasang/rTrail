package io.khasang.rtrail.controller;

import io.khasang.rtrail.entity.Location;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LocationControllerIntegrationTest {
    private final static String ROOT = "http://localhost:8080/location";
    private final static String ADD = "/add";
    private final static String UPDATE = "/update";
    private final static String DELETE = "/delete";
    private final static String ALL = "/all";
    private final static String GET_BY_ID = "/get";

    @Test
    public void checkAddLocationAndGet() {
        Location location = createLocation();

        RestTemplate template = new RestTemplate();
        ResponseEntity<Location> responseEntity = template.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                Location.class,
                location.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());

        Location recievedLocation = responseEntity.getBody();
        assertNotNull(recievedLocation);
    }

    @Test
    public void checkAllLocations() {
        createLocation();
        createLocation();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Location>> responseEntity = restTemplate.exchange(
                ROOT + GET_BY_ID + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Location>>() {
                }
        );

        List<Location> locations = responseEntity.getBody();
        assertNotNull(locations.get(0));
        assertNotNull(locations.get(1));
    }

    @Test
    public void checkUpdateLocation() {
        Location location = createLocation();
        location.setShort_description("we hunted 123");
        HttpHeaders headers = new  HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        HttpEntity<Location> httpEntity = new HttpEntity<>(location, headers);
        RestTemplate template = new RestTemplate();

        Location updatedLocation = template.exchange(
                ROOT + UPDATE,
                HttpMethod.PUT,
                httpEntity,
                Location.class
        ).getBody();

        assertEquals(location.getShort_description(), updatedLocation.getShort_description());
        assertNotNull(updatedLocation.getId());
    }

    @Test
    public void checkDeleteLocation() {
        Location location = createLocation();

        RestTemplate template = new RestTemplate();

        ResponseEntity<Location> deletedLocation = template.exchange(
                ROOT + DELETE + "?id={id}",
                HttpMethod.DELETE,
                null,
                Location.class,
                location.getId()
        );

        assertNotNull(deletedLocation.getBody());
    }

    private Location createLocation() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Location location = prefillLocation("forest");

        HttpEntity<Location> httpEntity = new HttpEntity<>(location, headers);
        RestTemplate template = new RestTemplate();

        Location createdLocation = template.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                httpEntity,
                Location.class
        ).getBody();

        assertEquals(createdLocation.getName(), createdLocation.getName());
        assertNotNull(createdLocation.getId());
        return createdLocation;
    }

    private Location prefillLocation(String name) {
        Location location = new Location();
        location.setName(name);
        location.setEvent("hunting");
        location.setDetailed_description("we hunted a bear");
        location.setShort_description("we hunted");
        return location;
    }
}
