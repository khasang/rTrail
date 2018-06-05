package io.khasang.rtrail.dao;


import io.khasang.rtrail.entity.Cat;
import org.hibernate.Session;

import java.util.List;

public interface BasicDao<T> {
    T create(T entity);

    T getById(long id);

    Session getSessionFactory();

    List<T> getList();

    T delete(T entityForDelete);

    T update(T entityForUpdate);
}
