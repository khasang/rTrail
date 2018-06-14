package io.khasang.rtrail.controller;

import io.khasang.rtrail.entity.Role;
import io.khasang.rtrail.entity.User;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
        assertEquals(Collections.singleton(Role.ROLE_ADMIN), receivedUser.getRoles());
        assertNotNull(receivedUser);
        removeUserFromDao(user);
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
        removeUserFromDao(user1);
        removeUserFromDao(user2);
    }

    @Test
    public void checkUpdateUser() {
        User user = createUser();
        user.setEmail("changedemail@test.me");
        user.setRoles(Collections.singleton(Role.ROLE_MODERATOR));
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

        assertEquals(user.getRoles(), updatedUser.getRoles());
        assertEquals(user.getEmail(), updatedUser.getEmail());
        assertNotNull(updatedUser.getId());

        removeUserFromDao(updatedUser);
    }

    @Test
    public void checkDeleteUser() {
        User user = createUser();

        RestTemplate template = new RestTemplate();

        ResponseEntity<User> deletedUser = template.exchange(
                ROOT + DELETE + "?id={id}",
                HttpMethod.DELETE,
                null,
                User.class,
                user.getId()
        );

        assertNotNull(deletedUser.getBody());
    }

    private User createUser() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        User user = prefillUser("testUserName", "password", "test@check.me", Collections.singleton(Role.ROLE_ADMIN));

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

    private User prefillUser(String username, String password, String email, Set<Role> userRole) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setActive(true);
        user.setRoles(userRole);
        return user;
    }

    private void removeUserFromDao(User user){
        RestTemplate template = new RestTemplate();
        template.exchange(
                ROOT + DELETE + "?id={id}",
                HttpMethod.DELETE,
                null,
                User.class,
                user.getId()
        );
    }
}
