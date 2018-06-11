package io.khasang.rtrail.service.impl;

import io.khasang.rtrail.dao.catalog.IblockDao;
import io.khasang.rtrail.dao.catalog.IblockElementDao;
import io.khasang.rtrail.dao.catalog.IblockSectionDao;
import io.khasang.rtrail.dto.IblockDTO;
import io.khasang.rtrail.dto.IblockElementDTO;
import io.khasang.rtrail.dto.IblockSectionDTO;
import io.khasang.rtrail.entity.catalog.Iblock;
import io.khasang.rtrail.entity.catalog.IblockElement;
import io.khasang.rtrail.entity.catalog.IblockSection;
import io.khasang.rtrail.service.CatalogService;
import io.khasang.rtrail.service.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    private IblockDao iblockDao;

    @Autowired
    private IblockSectionDao iblockSectionDao;

    @Autowired
    private IblockElementDao iblockElementDao;

    @Autowired
    private IblockDTO iblockDTO;

    @Autowired
    private IblockSectionDTO iblockSectionDTO;

    @Autowired
    private IblockElementDTO iblockElementDTO;

    @Override
    public Iblock addIblock(Iblock iblock) {
        return iblockDao.create(iblock);
    }

    @Override
    public IblockSection addIblockSection(IblockSection iblockSection) {
        return iblockSectionDao.create(iblockSection);
    }

    @Override
    public IblockElement addIblockElement(IblockElement iblockElement) {
        return iblockElementDao.create(iblockElement);
    }

    @Override
    public IblockDTO getIblockByCode(String code) {
        return iblockDTO.getIblockDTO(iblockDao.getByCode(code));
    }

    @Override
    public IblockSectionDTO getIblockSectionByCode(IblockDTO iblockDTO, String code) {
        Iblock iblock = iblockDTO.getIblock(iblockDTO);
        return iblockSectionDTO.getIblockSectionDTO(iblockSectionDao.getByCode(iblock, code));
    }

    @Override
    public IblockElementDTO getIblockElementByCode(IblockDTO iblockDTO, IblockSectionDTO iblockSectionDTO, String elementCode) {
        Iblock iblock = iblockDTO.getIblock(iblockDTO);
        IblockSection iblockSection = iblockSectionDTO.getIblockSection(iblockSectionDTO);
        return iblockElementDTO.getIblockElementDTO(iblockElementDao.getByCode(iblock, iblockSection, elementCode));
    }

    @Override
    public Map<String, String> getBreadcrumbs(IblockDTO iblockDTO, IblockSectionDTO iblockSectionDTO, IblockElementDTO iblockElementDTO) {

        Map<String, String> breadcrumbs = new LinkedHashMap<>();
        breadcrumbs.put("/", "Главная");
        breadcrumbs.put("/" + iblockDTO.getCode() + "/", "Каталог");
        if (iblockSectionDTO != null) {
            breadcrumbs.put("/" + iblockDTO.getCode() + "/" + iblockSectionDTO.getCode(), iblockSectionDTO.getName());
            if (iblockElementDTO != null) {
                breadcrumbs.put("/" + iblockDTO.getCode() + "/" + iblockSectionDTO.getCode() + "/" + iblockElementDTO.getCode(), iblockElementDTO.getName());
            }
        }

        return breadcrumbs;
    }

    @Override
    public List<Menu> getMenu(IblockDTO iblockDTO, IblockSectionDTO iblockSectionDTO, IblockElementDTO iblockElementDTO) {

        Iblock iblock = iblockDTO.getIblock(iblockDTO);

        List<IblockSection> iblockSectionList = iblockSectionDao.getList(iblock);

        List<Menu> menuItems = new LinkedList<>();
        for (IblockSection section : iblockSectionList) {

            Menu menuItem = new Menu(
                    section.getName(),
                    "/" + section.getIblock().getCode() + "/" + section.getCode(),
                    iblockSectionDTO != null && section.getId() == iblockSectionDTO.getId(),
                    iblockSectionDTO != null && section.getId() == iblockSectionDTO.getId() && iblockElementDTO == null
            );

            IblockSection iblockSection = iblockSectionDTO != null ? iblockSectionDTO.getIblockSection(iblockSectionDTO) : null;
            List<IblockElement> iblockElementList = iblockElementDao.getList(iblock, iblockSection);
            for (IblockElement element : iblockElementList) {
                Menu menuSubItem = new Menu(
                        element.getName(),
                        "/" + element.getIblock().getCode() + "/" + element.getIblock_section().getCode() + "/" + element.getCode(),
                        iblockElementDTO != null && element.getId() == iblockElementDTO.getId(),
                        iblockElementDTO != null && element.getId() == iblockElementDTO.getId()
                );
                menuItem.addSubMenu(menuSubItem);
            }

            menuItems.add(menuItem);
        }

        return menuItems;
    }

    @Override
    public void fillCatalog() {

        Iblock iblock = new Iblock("Каталог товаров", "catalog", "Интернет магазин автотоваров");
        addIblock(iblock);

        IblockSection iblockSection1 = new IblockSection("Видеорегистраторы", "videoregistratory", "Видеорегистраторы - это ...", iblock);
        IblockSection iblockSection2 = new IblockSection("Радар-детекторы", "radardetektory", "Радар-детекторы - это ...", iblock);
        IblockSection iblockSection3 = new IblockSection("Автохолодильники", "avtoholodilniki", "Автохолодильники - это ...", iblock);

        addIblockSection(iblockSection1);
        addIblockSection(iblockSection2);
        addIblockSection(iblockSection3);

        IblockElement iblockElement1 = new IblockElement("Видеорегистратор Artway AV-110", "videoregistrator-artway-AV-110", "Видеорегистратор Artway AV-110 предназначен для ...", iblock, iblockSection1);
        IblockElement iblockElement2 = new IblockElement("Видеорегистратор Prestigio RoadRunner 325", "videoregistrator-prestigio-roa", "Видеорегистратор Prestigio RoadRunner 325 предназначен для ...", iblock, iblockSection1);
        IblockElement iblockElement3 = new IblockElement("Радар-детектор Artway RD-516", "radar-detektor-artway-RD-516", "Радар-детектор Artway RD-516 предназначен для ...", iblock, iblockSection2);
        IblockElement iblockElement4 = new IblockElement("Радар-детектор Sho-Me 520 STR", "radar-detektor-sho-me-520-STR", "Радар-детектор Sho-Me 520 STR предназначен для ...", iblock, iblockSection2);
        IblockElement iblockElement5 = new IblockElement("Автохолодильник Starwind CF-123", "avtoholodilnik-starwind-CF-123", "Автохолодильник Starwind CF-123 предназначен для ...", iblock, iblockSection3);

        addIblockElement(iblockElement1);
        addIblockElement(iblockElement2);
        addIblockElement(iblockElement3);
        addIblockElement(iblockElement4);
        addIblockElement(iblockElement5);

    }

}
