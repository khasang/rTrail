package io.khasang.rtrail.controller;

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
        Comment comment = createComment();

        RestTemplate template = new RestTemplate();
        ResponseEntity<Comment> responseEntity = template.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                Comment.class,
                comment.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());

        Comment recComment = responseEntity.getBody();
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
        Comment comment = createComment();
        comment.setDescription("we hunted 123");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        HttpEntity<Comment> httpEntity = new HttpEntity<>(comment, headers);
        RestTemplate template = new RestTemplate();

        Comment updateComment = template.exchange(
                ROOT + UPDATE,
                HttpMethod.PUT,
                httpEntity,
                Comment.class
        ).getBody();

        assertEquals(comment.getName(), updateComment.getName());
        assertNotNull(updateComment.getId());


    }

    @Test
    public void checkDeleteComment() {
        Comment comment = createComment();

        RestTemplate template = new RestTemplate();

        ResponseEntity<Comment> deletedComment = template.exchange(
                ROOT + DELETE + "?id={id}",
                HttpMethod.DELETE,
                null,
                Comment.class,
                comment.getId()
        );

        assertNotNull(deletedComment.getBody());
    }

    private Comment createComment() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Comment comment = prefillComment("hunting");

        HttpEntity<Comment> httpEntity = new HttpEntity<>(comment, headers);
        RestTemplate template = new RestTemplate();

        Comment createdComment = template.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                httpEntity,
                Comment.class
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
