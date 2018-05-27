package io.khasang.rtrail.dao.interfaces;

import io.khasang.rtrail.entity.Iblock;
import io.khasang.rtrail.entity.IblockElement;

import java.util.List;

public interface IblockDao {
    void add(Iblock iblock);
    Iblock getIblockByCode(String code);
}
