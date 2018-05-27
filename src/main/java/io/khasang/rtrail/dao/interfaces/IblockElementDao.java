package io.khasang.rtrail.dao.interfaces;

import io.khasang.rtrail.entity.Iblock;
import io.khasang.rtrail.entity.IblockElement;
import io.khasang.rtrail.entity.IblockSection;

import java.util.List;

public interface IblockElementDao {
    void add(IblockElement iblockElement);
    List<IblockElement> listElements(Iblock iblock, IblockSection iblockSection);
    IblockElement getElementByCode(String code, Iblock iblock, IblockSection iblockSection);
}
