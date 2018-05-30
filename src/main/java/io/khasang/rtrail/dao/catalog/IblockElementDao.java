package io.khasang.rtrail.dao.catalog;

import io.khasang.rtrail.dao.BasicDao;
import io.khasang.rtrail.dao.catalog.impl.IblockElementDaoImpl;
import io.khasang.rtrail.entity.catalog.Iblock;
import io.khasang.rtrail.entity.catalog.IblockElement;
import io.khasang.rtrail.entity.catalog.IblockSection;

import java.util.List;

public interface IblockElementDao extends BasicDao<IblockElement> {

    /**
     * method for getting all elements of the section
     *
     * @param iblock        - elements iblock for getting
     * @param iblockSection - elements iblockSection for getting
     * @return all elements
     */
    List<IblockElement> getList(Iblock iblock, IblockSection iblockSection);

    /**
     * method for getting entity
     *
     * @param iblock        - entity's iblock for getting
     * @param iblockSection - entity's iblockSection for getting
     * @param code          - entity's code for getting
     * @return entity by iblock, iblockSection and code
     */
    IblockElement getByCode(Iblock iblock, IblockSection iblockSection, String code);

}
