package io.khasang.rtrail.service.impl;

import io.khasang.rtrail.dao.MessageDao;
import io.khasang.rtrail.entity.Message;
import io.khasang.rtrail.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageDao messageDao;

    @Override
    public Message addMessage(Message message) {
        return messageDao.create(message);
    }

    @Override
    public Message getMessageById(long id) {
        return messageDao.getById(id);
    }

    @Override
    public List<Message> getAllMessages() {
        return messageDao.getList();
    }

    @Override
    public Message deleteMessage(long id) {
        Message messageFoeDelete = getMessageById(id);
        return messageDao.delete(messageFoeDelete);
    }

    @Override
    public List<Message> getMessagesByDate(LocalDate date) {
        return messageDao.getByDate(date);
    }

    @Override
    public Message updateMessage(Message message) {
        return messageDao.update(message);
    }
}
