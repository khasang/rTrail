package io.khasang.rtrail.dao.impl;

import io.khasang.rtrail.dao.BasicDao;
import io.khasang.rtrail.entity.Cat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Transactional
public class BasicDaoImpl<T> implements BasicDao<T> {
    private final Class<T> entityClass;

    public BasicDaoImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Autowired
    protected SessionFactory sessionFactory;

    @Override
    public T create(T entity) {
        getSessionFactory().save(entity);
        return entity;
    }

    @Override
    public T getById(long id) {
        return getSessionFactory().get(entityClass, id);
    }

    @Override
    public Session getSessionFactory() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<T> getList() {
        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = builder.createQuery(entityClass);
        Root<T> root = criteriaQuery.from(entityClass);
        criteriaQuery.select(root);
        return getSessionFactory().createQuery(criteriaQuery).list();
    }

    @Override
    public T delete(T entityForDelete) {
        getSessionFactory().delete(entityForDelete);
        return entityForDelete;
    }

    @Override
    public T update(T entityForUpdate) {
        getSessionFactory().update(entityForUpdate);
        return entityForUpdate;
    }
}
