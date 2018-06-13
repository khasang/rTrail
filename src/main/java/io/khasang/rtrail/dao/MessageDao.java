package io.khasang.rtrail.dao;

import io.khasang.rtrail.entity.Message;

import java.time.LocalDate;
import java.util.List;
public interface MessageDao extends BasicDao<Message>{
    /**
     * method for getting messages by date
     *
     * @param date = filter
     * @return messages by date
     */
    List<Message> getByDate(LocalDate date);
}
