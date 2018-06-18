package io.khasang.rtrail.dao.impl;

import io.khasang.rtrail.dao.CommentDao;
import io.khasang.rtrail.entity.Comment;

import java.util.List;

public class CommentDaoImpl extends BasicDaoImpl<Comment> implements CommentDao {

    public CommentDaoImpl(Class<Comment> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Comment> getByName(String name) {
        return (List<Comment>) getSessionFactory().
                createQuery("from Comment as c where c.name = ?").setParameter(0, name).list();
    }
}
