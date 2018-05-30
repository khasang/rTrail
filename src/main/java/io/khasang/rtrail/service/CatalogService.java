package io.khasang.rtrail.service;

import io.khasang.rtrail.entity.catalog.Iblock;
import io.khasang.rtrail.entity.catalog.IblockElement;
import io.khasang.rtrail.entity.catalog.IblockSection;

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
     * method for add iblockSection
     *
     * @param iblockSection - new iblockSection for creation
     * @return created iblockSection
     */
    IblockSection addIblockSection(IblockSection iblockSection);

    /**
     * method for add iblockElement
     *
     * @param iblockElement - new iblockElement for creation
     * @return created iblockElement
     */
    IblockElement addIblockElement(IblockElement iblockElement);

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

    /**
     * method for getting iblockSection
     *
     * @param iblock - entity's iblock for getting
     * @param code - iblockSection's code for getting
     * @return iblockSection by iblock and code
     */
    IblockSection getIblockSectionByCode(Iblock iblock, String code);

    /**
     * method for getting all elements of the section
     *
     * @param iblock - elements iblock for getting
     * @param iblockSection - elements iblockSection for getting
     * @return elements by iblock and iblockSection
     */
    Map<String, String> getIblockElements(Iblock iblock, IblockSection iblockSection);

    /**
     * method for getting iblockElement
     *
     * @param iblock - entity's iblock for getting
     * @param iblockSection - entity's iblockSection for getting
     * @param iblockSection - iblockElement's iblockSection for getting
     * @return iblockElement by iblock, iblockSection and elementCode
     */
    IblockElement getIblockElementByCode(Iblock iblock, IblockSection iblockSection, String elementCode);
}
