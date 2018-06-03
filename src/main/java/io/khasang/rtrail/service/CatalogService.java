package io.khasang.rtrail.service;

import io.khasang.rtrail.entity.catalog.Iblock;
import io.khasang.rtrail.entity.catalog.IblockElement;
import io.khasang.rtrail.entity.catalog.IblockSection;

import java.util.List;
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
     * method for getting iblockSection
     *
     * @param iblock - entity's iblock for getting
     * @param code   - iblockSection's code for getting
     * @return iblockSection by iblock and code
     */
    IblockSection getIblockSectionByCode(Iblock iblock, String code);

    /**
     * method for getting iblockElement
     *
     * @param iblock        - entity's iblock for getting
     * @param iblockSection - entity's iblockSection for getting
     * @param iblockSection - iblockElement's iblockSection for getting
     * @return iblockElement by iblock, iblockSection and elementCode
     */
    IblockElement getIblockElementByCode(Iblock iblock, IblockSection iblockSection, String elementCode);

    /**
     * method for getting breadcrumbs
     *
     * @param iblock        - entity's iblock for getting
     * @param iblockSection - entity's iblockSection for getting
     * @param iblockElement - entity's iblockElement for getting
     * @return LinkedHashMap<String , String> by iblock, iblockSection, iblockElement
     */
    Map<String, String> getBreadcrumbs(Iblock iblock, IblockSection iblockSection, IblockElement iblockElement);

    /**
     * method for getting menu
     *
     * @param iblock        - entity's iblock for getting
     * @param iblockSection - entity's iblockSection for getting
     * @param iblockElement - entity's iblockElement for getting
     * @return LinkedHashMap<Menu> by iblock, iblockSection, iblockElement
     */
    List<Menu> getMenu(Iblock iblock, IblockSection iblockSection, IblockElement iblockElement);
}
