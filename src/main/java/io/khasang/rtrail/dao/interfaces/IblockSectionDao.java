package io.khasang.rtrail.dao.interfaces;

import io.khasang.rtrail.entity.Iblock;
import io.khasang.rtrail.entity.IblockSection;

import java.util.List;

public interface IblockSectionDao {
    void add(IblockSection iblockSection);

    List<IblockSection> listSections(Iblock iblock);

    IblockSection getSectionByCode(String code, Iblock iblock);
}
