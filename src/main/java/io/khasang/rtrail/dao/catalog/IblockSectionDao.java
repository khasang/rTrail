package io.khasang.rtrail.dao.catalog;

import io.khasang.rtrail.dao.BasicDao;
import io.khasang.rtrail.entity.catalog.Iblock;
import io.khasang.rtrail.entity.catalog.IblockElement;
import io.khasang.rtrail.entity.catalog.IblockSection;

import java.util.List;
import java.util.Map;

public interface IblockSectionDao extends BasicDao<IblockSection> {

    /**
     * method for getting all entities
     *
     * @param iblock - entity's iblock for getting
     * @return all entities
     */
    List<IblockSection> getList(Iblock iblock);

    /**
     * method for getting entity
     *
     * @param iblock - entity's iblock for getting
     * @param code - entity's code for getting
     * @return entity by iblock and code
     */
    IblockSection getByCode(Iblock iblock, String code);
}
