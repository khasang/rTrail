package io.khasang.rtrail.dao.impl;

import io.khasang.rtrail.dao.MessageDao;
import io.khasang.rtrail.entity.Message;

import java.time.LocalDate;
import java.util.List;

public class MessageDaoImpl extends BasicDaoImpl<Message> implements MessageDao {
    public MessageDaoImpl(Class<Message> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Message> getByDate(LocalDate date) {
        return (List<Message>) getSessionFactory().
                createQuery("from Message as m where m.date = ?").setParameter(0, date).list();
    }
}
