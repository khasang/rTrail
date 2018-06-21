package io.khasang.rtrail.service;

import io.khasang.rtrail.entity.Message;

import java.time.LocalDate;
import java.util.List;

public interface MessageService {

    /**
     * method for add message
     *
     * @param message - new message for creation
     * @return created message
     */
    Message addMessage(Message message);

    /**
     * method for getting message
     *
     * @param id - message's id for getting
     * @return message by id
     */
    Message getMessageById(long id);

    /**
     * method for getting all messages
     *
     * @return all messages
     */
    List<Message> getAllMessages();

    /**
     * method for deletion message
     *
     * @param id - message's id for delete
     * @return deleted message
     */
    Message deleteMessage(long id);

    /**
     * method for getting messages by date
     *
     * @param date = filter
     * @return messages by date
     */
    List<Message> getMessagesByDate(LocalDate date);

    /**
     * method for update message
     *
     * @param  message - message for updating
     * @return updated message
     */
    Message updateMessage(Message message);
}
