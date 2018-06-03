package io.khasang.rtrail.dao.catalog.impl;

import io.khasang.rtrail.dao.catalog.IblockSectionDao;
import io.khasang.rtrail.dao.impl.BasicDaoImpl;
import io.khasang.rtrail.entity.catalog.Iblock;
import io.khasang.rtrail.entity.catalog.IblockElement;
import io.khasang.rtrail.entity.catalog.IblockSection;

import java.util.List;


public class IblockSectionDaoImpl extends BasicDaoImpl<IblockSection> implements IblockSectionDao {
    public IblockSectionDaoImpl(Class<IblockSection> entityClass) {
        super(entityClass);
    }

    @Override
    public List<IblockSection> getList(Iblock iblock) {

        return (List<IblockSection>) getSessionFactory()
                .createQuery("from IblockSection where iblock = ?")
                .setParameter(0, iblock)
                .list();
    }

    @Override
    public IblockSection getByCode(Iblock iblock, String code) {

        List list = getSessionFactory()
                .createQuery("from IblockSection where iblock = ? and code = ?")
                .setParameter(0, iblock)
                .setParameter(1, code)
                .list();

        return list.size() > 0 ? (IblockSection) list.get(0) : null;
    }
}
