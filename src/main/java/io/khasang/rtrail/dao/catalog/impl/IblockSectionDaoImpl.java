package io.khasang.rtrail.dao.catalog.impl;

import io.khasang.rtrail.dao.catalog.IblockSectionDao;
import io.khasang.rtrail.dao.impl.BasicDaoImpl;
import io.khasang.rtrail.entity.catalog.IblockSection;


public class IblockSectionDaoImpl extends BasicDaoImpl<IblockSection> implements IblockSectionDao {
    public IblockSectionDaoImpl(Class<IblockSection> entityClass) {
        super(entityClass);
    }
}
