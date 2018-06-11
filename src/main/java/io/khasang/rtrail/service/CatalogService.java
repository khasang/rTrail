package io.khasang.rtrail.service;

import io.khasang.rtrail.dto.IblockDTO;
import io.khasang.rtrail.dto.IblockElementDTO;
import io.khasang.rtrail.dto.IblockSectionDTO;
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
    IblockDTO getIblockByCode(String code);

    /**
     * method for getting iblockSection
     *
     * @param iblockDTO - entity's iblock for getting
     * @param code   - entity's code for getting
     * @return iblockSection by iblock and code
     */
    IblockSectionDTO getIblockSectionByCode(IblockDTO iblockDTO, String code);

    /**
     * method for getting iblockElement
     *
     * @param iblockDTO        - entity's iblock for getting
     * @param iblockSectionDTO - entity's iblockSection for getting
     * @param elementCode - entity's elementCode for getting
     * @return iblockElement by iblock, iblockSection and elementCode
     */
    IblockElementDTO getIblockElementByCode(IblockDTO iblockDTO, IblockSectionDTO iblockSectionDTO, String elementCode);

    /**
     * method for getting breadcrumbs
     *
     * @param iblockDTO        - entity's iblock for getting
     * @param iblockSectionDTO - entity's iblockSection for getting
     * @param iblockElementDTO - entity's iblockElement for getting
     * @return LinkedHashMap<String , String> by iblock, iblockSection, iblockElement
     */
    Map<String, String> getBreadcrumbs(IblockDTO iblockDTO, IblockSectionDTO iblockSectionDTO, IblockElementDTO iblockElementDTO);

    /**
     * method for getting menu
     *
     * @param iblockDTO        - entity's iblock for getting
     * @param iblockSectionDTO - entity's iblockSection for getting
     * @param iblockElementDTO - entity's iblockElement for getting
     * @return LinkedHashMap<Menu> by iblock, iblockSection, iblockElement
     */
    List<Menu> getMenu(IblockDTO iblockDTO, IblockSectionDTO iblockSectionDTO, IblockElementDTO iblockElementDTO);

    /**
     * Fill empty catalog
     * */
    void fillCatalog();
}
