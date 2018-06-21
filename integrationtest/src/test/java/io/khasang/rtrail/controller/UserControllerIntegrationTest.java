package io.khasang.rtrail.controller;

import io.khasang.rtrail.dto.UserDTO;
import io.khasang.rtrail.entity.Role;
import io.khasang.rtrail.entity.RoleEnum;
import io.khasang.rtrail.entity.User;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

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
        UserDTO user = createUser();

        RestTemplate template = new RestTemplate();
        ResponseEntity<UserDTO> responseEntity = template.exchange(
                ROOT + GET + "/{id}",
                HttpMethod.GET,
                null,
                UserDTO.class,
                user.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        UserDTO receivedUser = responseEntity.getBody();
        assertNotNull(receivedUser);
        removeUserFromDao(user);
    }

    @Test
    public void checkAllUsers() {
        UserDTO user1 = createUser();
        UserDTO user2 = createUser();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<UserDTO>> responseEntity = restTemplate.exchange(
                ROOT + GET + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<UserDTO>>() {
                }
        );

        List<UserDTO> users = responseEntity.getBody();
        assertNotNull(users.get(0));
        assertNotNull(users.get(1));
        removeUserFromDao(user1);
        removeUserFromDao(user2);
    }

    @Test
    public void checkUpdateUser() {
        UserDTO user = createUser();
        user.setEmail("changedemail@test.me");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        HttpEntity<UserDTO> httpEntity = new HttpEntity<>(user, headers);
        RestTemplate template = new RestTemplate();

        UserDTO updatedUser = template.exchange(
                ROOT + UPDATE,
                HttpMethod.PUT,
                httpEntity,
                UserDTO.class
        ).getBody();

        assertEquals(user.getEmail(), updatedUser.getEmail());
        assertNotNull(updatedUser.getId());
        removeUserFromDao(user);
    }

    @Test
    public void checkDeleteUser() {
        UserDTO user = createUser();

        RestTemplate template = new RestTemplate();

        ResponseEntity<UserDTO> deletedUser = template.exchange(
                ROOT + DELETE + "?id={id}",
                HttpMethod.DELETE,
                null,
                UserDTO.class,
                user.getId()
        );

        assertNotNull(deletedUser.getBody());
    }

    private UserDTO createUser() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        Role role = new Role();
        role.setRoleName(RoleEnum.ROLE_USER.name());
        List<Role> roleList = new ArrayList<>();
        roleList.add(role);

        User user = prefillUser("testUserName", "password", "test@check.me", roleList);

        HttpEntity<User> httpEntity = new HttpEntity<>(user, headers);
        RestTemplate template = new RestTemplate();

        UserDTO createdUser = template.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                httpEntity,
                UserDTO.class
        ).getBody();

        assertEquals(user.getUsername(), createdUser.getUsername());
        assertNotNull(createdUser.getId());
        assertEquals(roleList, user.getRoleList());
        return createdUser;
    }

    private User prefillUser(String username, String password, String email, List<Role> roleList) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setRoleList(roleList);
        return user;
    }

    private void removeUserFromDao(UserDTO user){
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
