package io.khasang.rtrail.dao.impl;

import io.khasang.rtrail.dao.RoutDao;
import io.khasang.rtrail.entity.Rout;

import java.util.List;

/**
 * concrete realize of RoutDao
 */
public class RoutDaoImpl extends BasicDaoImpl<Rout> implements RoutDao {

    public RoutDaoImpl(Class<Rout> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Rout> getByName(String name) {
        return (List<Rout>) getSessionFactory()
                .createQuery("from Rout as r where r.name = ?").setParameter(0, name).list();
    }

    @Override
    public List<Rout> getByOwner(String owner) {
        return (List<Rout>) getSessionFactory()
                .createQuery("from Rout as r where r.owner = ?").setParameter(0, owner).list();
    }
}