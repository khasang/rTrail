package io.khasang.rtrail.controller;

import io.khasang.rtrail.entity.Message;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.Assert.*;

public class MessageControllerIntegrationTest {

    private final static String ROOT = "http://localhost:8080/message";
    private final static String ADD = "/add";
    private final static String ALL = "/all";
    private final static String UPDATE = "/update";
    private final static String DELETE = "/delete";
    private final static String GET = "/get";
    private final static String DATE = "/date";

       @Test
    public void checkAddMessageAndGet() {
        Message message = createdMessage();

        RestTemplate template = new RestTemplate();
        ResponseEntity<Message> responseEntity = template.exchange(
                ROOT + GET + "/{id}",
                HttpMethod.GET,
                null,
                Message.class,
                message.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Message receivedMessage = responseEntity.getBody();
        assertNotNull(receivedMessage);
        assertNotNull(receivedMessage.getText());
        assertNotNull(receivedMessage.getDate());
        assertEquals(message.getId(), receivedMessage.getId());

        deleteMessageById(message.getId());
    }

    @Test
    public void checkGetMessageById() {
        Message message = createdMessage();

        RestTemplate template = new RestTemplate();
        ResponseEntity<Message> responseEntity = template.exchange(
                ROOT + GET + "/{id}",
                HttpMethod.GET,
                null,
                Message.class,
                message.getId()
        );

        Message receivedMessage = responseEntity.getBody();
        assertNotNull(receivedMessage);
        assertNotNull(receivedMessage.getId());
        assertEquals(message.getId(), receivedMessage.getId());
    }

    @Test
    public void checkDeleteMessage() {
        Message message = createdMessage();

        RestTemplate template = new RestTemplate();

        Message deletedMessage = deleteMessageById(message.getId());

        assertNotNull(deletedMessage.getText());

        ResponseEntity<Message> responseForDeleteMessage = template.exchange(
                ROOT + GET + "/{id}",
                HttpMethod.GET,
                null,
                Message.class,
                deletedMessage.getId()
        );

        assertEquals("OK", responseForDeleteMessage.getStatusCode().getReasonPhrase());
        assertNull(responseForDeleteMessage.getBody());
    }

    @Test
    public void checkAllMessages() {
        createdMessage();
        createdMessage();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Message>> responseEntity = restTemplate.exchange(
                ROOT + GET + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Message>>() {
                }
        );

        List<Message> messages = responseEntity.getBody();
        assertNotNull(messages.get(0));
        assertNotNull(messages.get(1));
    }

    @Test
    public void checkGetMessageByDate() {
        Message message = createdMessage();

        RestTemplate template = new RestTemplate();
        ResponseEntity<List<Message>> responseEntity = template.exchange(
                ROOT + GET + DATE + "/{date}",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Message>>() {
                },
                message.getDate()
        );

        List<Message> catList = responseEntity.getBody();
        assertNotNull(catList);
        for (Message receivedCat : catList) {
            assertEquals(message.getText(), receivedCat.getText());
        }
    }

    @Test
    public void checkUpdateMessage() {
        String newMessageText = "new message";

        Message message = createdMessage();

        message.setText(newMessageText);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<Message> httpEntity = new HttpEntity<>(message, headers);

        RestTemplate template = new RestTemplate();
        ResponseEntity<Message> responseEntity = template.exchange(
                ROOT + UPDATE,
                HttpMethod.PUT,
                httpEntity,
                Message.class
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Message receivedMessage = responseEntity.getBody();
        assertNotNull(receivedMessage);
        assertEquals(newMessageText, receivedMessage.getText());
    }

    private Message createdMessage() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Message message = prefillMessage(
                "Well, hello there",
                LocalDate.of(2018, 6, 1),
                LocalTime.of(12, 30, 5)
        );

        HttpEntity<Message> httpEntity = new HttpEntity<>(message, headers);
        RestTemplate template = new RestTemplate();
        Message createdMessage = template.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                httpEntity,
                Message.class
        ).getBody();

        assertNotNull(createdMessage);
        assertEquals(message.getText(), createdMessage.getText());
        return createdMessage;
    }

    private Message prefillMessage(String text, LocalDate date, LocalTime time) {
        Message message = new Message();
        message.setText(text);
        message.setDate(date);
        message.setTime(time);

        return message;
    }

    private Message deleteMessageById(Long id) {
        RestTemplate template = new RestTemplate();
        ResponseEntity<Message> responseEntity = template.exchange(
                ROOT + DELETE + "/?id={id}",
                HttpMethod.DELETE,
                null,
                Message.class,
                id
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());

        return responseEntity.getBody();
    }
}
