package io.khasang.rtrail.dao.catalog;

import io.khasang.rtrail.dao.BasicDao;
import io.khasang.rtrail.entity.catalog.Iblock;

public interface IblockDao extends BasicDao<Iblock> {

    /**
     * method for getting entity
     *
     * @param code - entity's code for getting
     * @return entity by code
     */
    Iblock getByCode(String code);
}
