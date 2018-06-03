package io.khasang.rtrail.service.impl;

import io.khasang.rtrail.dao.catalog.IblockDao;
import io.khasang.rtrail.dao.catalog.IblockElementDao;
import io.khasang.rtrail.dao.catalog.IblockSectionDao;
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
    public Iblock getIblockByCode(String code) {
        return iblockDao.getByCode(code);
    }

    @Override
    public IblockSection getIblockSectionByCode(Iblock iblock, String code) {
        return iblockSectionDao.getByCode(iblock, code);
    }

    @Override
    public IblockElement getIblockElementByCode(Iblock iblock, IblockSection iblockSection, String elementCode) {
        return iblockElementDao.getByCode(iblock, iblockSection, elementCode);
    }

    @Override
    public Map<String, String> getBreadcrumbs(Iblock iblock, IblockSection iblockSection, IblockElement iblockElement) {

        Map<String, String> breadcrumbs = new LinkedHashMap<>();
        breadcrumbs.put("/", "Главная");
        if (iblockSection != null) {
            breadcrumbs.put("/" + iblock.getCode() + "/" + iblockSection.getCode(), iblockSection.getName());
            if (iblockElement != null) {
                breadcrumbs.put("/" + iblock.getCode() + "/" + iblockSection.getCode() + "/" + iblockElement.getCode(), iblockElement.getName());
            }
        }

        return breadcrumbs;
    }

    @Override
    public List<Menu> getMenu(Iblock iblock, IblockSection iblockSection, IblockElement iblockElement) {
        List<IblockSection> iblockSectionList = iblockSectionDao.getList(iblock);

        List<Menu> menuItems = new LinkedList<>();
        for (IblockSection section : iblockSectionList) {

            Menu menuItem = new Menu(
                    section.getName(),
                    "/" + section.getIblock().getCode() + "/" + section.getCode(),
                    iblockSection != null && section.getId() == iblockSection.getId(),
                    iblockSection != null && section.getId() == iblockSection.getId() && iblockElement == null
            );

            List<IblockElement> iblockElementList = iblockElementDao.getList(iblock, iblockSection);
            for (IblockElement element : iblockElementList) {
                Menu menuSubItem = new Menu(
                        element.getName(),
                        "/" + element.getIblock().getCode() + "/" + element.getIblock_section().getCode() + "/" + element.getCode(),
                        iblockElement != null && element.getId() == iblockElement.getId(),
                        iblockElement != null && element.getId() == iblockElement.getId()
                );
                menuItem.addSubMenu(menuSubItem);
            }

            menuItems.add(menuItem);
        }

        return menuItems;
    }

}
