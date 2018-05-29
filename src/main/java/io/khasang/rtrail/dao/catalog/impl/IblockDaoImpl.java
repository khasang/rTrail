package io.khasang.rtrail.dao.catalog.impl;

import io.khasang.rtrail.dao.catalog.IblockDao;
import io.khasang.rtrail.dao.impl.BasicDaoImpl;
import io.khasang.rtrail.entity.catalog.Iblock;

public class IblockDaoImpl extends BasicDaoImpl<Iblock> implements IblockDao {
    public IblockDaoImpl(Class<Iblock> entityClass) {
        super(entityClass);
    }
}

