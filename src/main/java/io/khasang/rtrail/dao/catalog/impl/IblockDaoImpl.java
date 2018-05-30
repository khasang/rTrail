package io.khasang.rtrail.dao.catalog.impl;

import io.khasang.rtrail.dao.catalog.IblockDao;
import io.khasang.rtrail.dao.impl.BasicDaoImpl;
import io.khasang.rtrail.entity.catalog.Iblock;

import java.util.List;

public class IblockDaoImpl extends BasicDaoImpl<Iblock> implements IblockDao {

    public IblockDaoImpl(Class<Iblock> entityClass) {
        super(entityClass);
    }

    @Override
    public Iblock getByCode(String code) {

        List list = getSessionFactory()
                .createQuery("from Iblock where code = ?")
                .setParameter(0, code)
                .list();

        return list.size() > 0 ? (Iblock) list.get(0) : null;
    }
}


