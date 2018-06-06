package io.khasang.rtrail.dao.impl;

import io.khasang.rtrail.dao.RoutDao;
import io.khasang.rtrail.entity.Rout;

/**
 * concrete realize of RoutDao
 */
public class RoutDaoImpl extends BasicDaoImpl<Rout> implements RoutDao {
    public RoutDaoImpl(Class<Rout> entityClass) {
        super(entityClass);
    }
}