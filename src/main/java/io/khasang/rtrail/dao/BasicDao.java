package io.khasang.rtrail.dao;

import org.hibernate.Session;

import java.util.List;

public interface BasicDao<T> {

    T create(T entity);

    T getById(long id);

    Session getSessionFactory();

    T delete(T entityToDelete);

    List<T> getAll();

    T update(T entity);
}
