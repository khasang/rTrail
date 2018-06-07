package io.khasang.rtrail.controller;

import io.khasang.rtrail.entity.User;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class UserControllerIntegrationTest {

    private final static String ROOT = "http://localhost:8080/users";
    private final static String ADD = "/add";
    private final static String ALL = "/all";
    private final static String UPDATE = "/update";
    private final static String DELETE = "/delete";
    private final static String GET = "/get";

    @Test
    public void checkAddUserAndGet() {
        User user = createUser();

        RestTemplate template = new RestTemplate();
        ResponseEntity<User> responseEntity = template.exchange(
                ROOT + GET + "/{id}",
                HttpMethod.GET,
                null,
                User.class,
                user.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());

        User receivedUser = responseEntity.getBody();
        assertNotNull(receivedUser);
    }

    @Test
    public void checkAllUsers() {
        User user1 = createUser();
        User user2 = createUser();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<User>> responseEntity = restTemplate.exchange(
                ROOT + GET + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<User>>() {
                }
        );

        List<User> users = responseEntity.getBody();
        assertNotNull(users.get(0));
        assertNotNull(users.get(1));

        // restTemplate.delete(ROOT+DELETE, user1.getId());
        //restTemplate.delete(ROOT+DELETE, user2.getId());
        // clean
    }

    @Test
    public void checkUpdateUser() {
        User user = createUser();
        user.setEmail("changedemail@test.me");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        HttpEntity<User> httpEntity = new HttpEntity<>(user, headers);
        RestTemplate template = new RestTemplate();

        User updatedUser = template.exchange(
                ROOT + UPDATE,
                HttpMethod.PUT,
                httpEntity,
                User.class
        ).getBody();

        assertEquals(user.getEmail(), updatedUser.getEmail());
        assertNotNull(updatedUser.getId());
        //template.delete(ROOT+DELETE);

    }

    @Test
    public void checkDeleteUser() {
        User user = createUser();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        HttpEntity<User> httpEntity = new HttpEntity<>(user, headers);
        RestTemplate template = new RestTemplate();

        User deletedUser = template.exchange(
                ROOT + DELETE + "{id}",
                HttpMethod.DELETE,
                httpEntity,
                User.class,
                user.getId()

        ).getBody();

        System.out.println(deletedUser);
        assertNull(deletedUser.getId());
    }

    private User createUser() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        User user = prefillUser("testUserName", "password", "test@check.me");

        HttpEntity<User> httpEntity = new HttpEntity<>(user, headers);
        RestTemplate template = new RestTemplate();

        User createdUser = template.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                httpEntity,
                User.class
        ).getBody();

        assertEquals(user.getUsername(), createdUser.getUsername());
        assertNotNull(createdUser.getId());
        return createdUser;
    }

    private User prefillUser(String username, String password, String email) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        return user;
    }
}
