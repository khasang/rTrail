package io.khasang.rtrail.controller;

import io.khasang.rtrail.dto.CommentDTO;
import io.khasang.rtrail.entity.Comment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CommentControllerIntegrationTest {
    private final static String ROOT = "http://localhost:8080/comment";
    private final static String ADD = "/add";
    private final static String ALL = "/all";
    private final static String GET_BY_ID = "/get";
    private final static String UPDATE = "/update";
    private final static String DELETE = "/delete";

    @Before
    public void init() {

    }

    @After
    public void cleanUp() {

    }

    @Test
    public void checkAddCommentAndGet() {
        CommentDTO comment = createComment();

        RestTemplate template = new RestTemplate();
        ResponseEntity<CommentDTO> responseEntity = template.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                CommentDTO.class,
                comment.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());

        CommentDTO recComment = responseEntity.getBody();
        assertNotNull(recComment);
    }

    @Test
    public void checkAllComments() {
        // clean
        createComment();
        createComment();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Comment>> responseEntity = restTemplate.exchange(
                ROOT + GET_BY_ID + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Comment>>() {
                }
        );

        List<Comment> comments = responseEntity.getBody();
        assertNotNull(comments.get(0));
        assertNotNull(comments.get(1));

        // clean
    }

    @Test
    public void checkUpdateLocation() {
        CommentDTO comment = createComment();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        comment.setName("we hunted 123");
        CommentDTO commentDTO = new CommentDTO();
        HttpEntity<CommentDTO> httpEntity = new HttpEntity<>(commentDTO, headers);
        RestTemplate template = new RestTemplate();

        CommentDTO updateComment = template.exchange(
                ROOT + UPDATE,
                HttpMethod.PUT,
                httpEntity,
                CommentDTO.class
        ).getBody();

        ResponseEntity<CommentDTO> responseEntity = template.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                CommentDTO.class,
                updateComment.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());

        CommentDTO receivedCat = responseEntity.getBody();
        assertNotNull(receivedCat);
        assertEquals("New Name", receivedCat.getName());
    }

    @Test
    public void checkDeleteComment() {
        CommentDTO comment = createComment();

        RestTemplate template = new RestTemplate();

        ResponseEntity<CommentDTO> deletedComment = template.exchange(
                ROOT + DELETE + "?id={id}",
                HttpMethod.DELETE,
                null,
                CommentDTO.class,
                comment.getId()
        );

        assertNotNull(deletedComment.getBody());
    }

    private CommentDTO createComment() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Comment comment = prefillComment("hunting");

        HttpEntity<Comment> httpEntity = new HttpEntity<>(comment, headers);
        RestTemplate template = new RestTemplate();

        CommentDTO createdComment = template.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                httpEntity,
                CommentDTO.class
        ).getBody();

        assertEquals(comment.getName(), createdComment.getName());
        assertNotNull(createdComment.getId());
        return createdComment;
    }

    private Comment prefillComment(String name) {
        Comment comment = new Comment();
        comment.setName(name);
        comment.setDescription("bear hunt ");

        return comment;
    }
}
