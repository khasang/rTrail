package io.khasang.rtrail.service;

import io.khasang.rtrail.entity.catalog.Iblock;

import java.util.Map;

public interface CatalogService {

    /**
     * method for add iblock
     *
     * @param iblock - new iblock for creation
     * @return created iblock
     */
    Iblock addIblock(Iblock iblock);

    /**
     * method for getting iblock
     *
     * @param code - iblock's code for getting
     * @return iblock by code
     */
    Iblock getIblockByCode(String code);

    /**
     * method for getting sections
     *
     * @param iblock - sections iblock for getting
     * @return sections by iblock
     */
    Map<String, String> getIblockSections(Iblock iblock);
}
