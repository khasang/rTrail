package io.khasang.rtrail.dao.impl;

import io.khasang.rtrail.dao.CatDao;
import io.khasang.rtrail.entity.Cat;

public class CatDaoImpl extends BasicDaoImpl<Cat> implements CatDao {
    public CatDaoImpl(Class<Cat> entityClass) {
        super(entityClass);
    }
}
