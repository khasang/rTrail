package io.khasang.rtrail.dao.impl;

import io.khasang.rtrail.dao.AuthorDao;
import io.khasang.rtrail.entity.Author;

import java.util.List;

public class AuthorDaoImpl extends BasicDaoImpl<Author> implements AuthorDao {
    public AuthorDaoImpl(Class<Author> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Author> getByFirstName(String firstName) {
        return (List<Author>) getSessionFactory().
                createQuery("from Author as a where a.firstName = ?").setParameter(0, firstName).list();
    }

    @Override
    public List<Author> getByLastName(String lastName) {
        return (List<Author>) getSessionFactory().
                createQuery("from Author as a where a.lastName = ?").setParameter(0, lastName).list();
    }
}

