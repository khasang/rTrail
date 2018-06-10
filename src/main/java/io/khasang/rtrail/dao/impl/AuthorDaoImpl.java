package io.khasang.rtrail.dao.impl;

import io.khasang.rtrail.dao.AuthorDao;
import io.khasang.rtrail.entity.Author;

import java.util.List;

public class AuthorDaoImpl extends BasicDaoImpl<Author> implements AuthorDao {
    public AuthorDaoImpl(Class<Author> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Author> getAuthorByName(String authorname) {
        return (List<Author>) getSessionFactory().
                createQuery("from Author as a where a.authorName = ?").setParameter(0, authorname).list();
    }
}
