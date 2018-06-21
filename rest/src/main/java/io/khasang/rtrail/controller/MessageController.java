package io.khasang.rtrail.controller;

import io.khasang.rtrail.entity.Message;
import io.khasang.rtrail.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Message addMessage(@RequestBody Message message) {
        return messageService.addMessage(message);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Message getMessageById(@PathVariable(value = "id") String id) {
        return messageService.getMessageById(Long.parseLong(id));
    }

    @RequestMapping(value = "/get/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Message> getMessages() {
        return messageService.getAllMessages();
    }

    @RequestMapping(value = "/get/date/{date}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Message> getMessageByDate(@PathVariable(value = "date") String date) {
        return messageService.getMessagesByDate(LocalDate.parse(date));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Message deleteMessage(@RequestParam(value = "id") String id) {
        return messageService.deleteMessage(Long.parseLong(id));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Message updateMessage(@RequestBody Message message) {
        return messageService.updateMessage(message);
    }
}
