package io.khasang.rtrail.dao.catalog.impl;

import io.khasang.rtrail.dao.catalog.IblockElementDao;
import io.khasang.rtrail.dao.impl.BasicDaoImpl;
import io.khasang.rtrail.entity.catalog.Iblock;
import io.khasang.rtrail.entity.catalog.IblockElement;
import io.khasang.rtrail.entity.catalog.IblockSection;

import java.util.List;


public class IblockElementDaoImpl extends BasicDaoImpl<IblockElement> implements IblockElementDao {

    public IblockElementDaoImpl(Class<IblockElement> entityClass) {
        super(entityClass);
    }

    @Override
    public List<IblockElement> getList(Iblock iblock, IblockSection iblockSection) {

        return (List<IblockElement>) getSessionFactory()
                .createQuery("from IblockElement where iblock = ? and iblock_section = ?")
                .setParameter(0, iblock)
                .setParameter(1, iblockSection)
                .list();
    }

    @Override
    public IblockElement getByCode(Iblock iblock, IblockSection iblockSection, String code) {

        List list = getSessionFactory()
                .createQuery("from IblockElement where iblock = ? and iblock_section = ? and code = ?")
                .setParameter(0, iblock)
                .setParameter(1, iblockSection)
                .setParameter(2, code)
                .list();

        return list.size() > 0 ? (IblockElement) list.get(0) : null;
    }
}
