package io.khasang.rtrail.dao.catalog;

import io.khasang.rtrail.entity.catalog.Iblock;
import io.khasang.rtrail.entity.catalog.IblockElement;
import io.khasang.rtrail.entity.catalog.IblockSection;

import java.util.List;

public interface IblockElementDao {
    void add(IblockElement iblockElement);
    List<IblockElement> listElements(Iblock iblock, IblockSection iblockSection);
    IblockElement getElementByCode(String code, Iblock iblock, IblockSection iblockSection);
}
