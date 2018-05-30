package io.khasang.rtrail.service.impl;

import io.khasang.rtrail.dao.catalog.IblockDao;
import io.khasang.rtrail.dao.catalog.IblockElementDao;
import io.khasang.rtrail.dao.catalog.IblockSectionDao;
import io.khasang.rtrail.entity.catalog.Iblock;
import io.khasang.rtrail.entity.catalog.IblockElement;
import io.khasang.rtrail.entity.catalog.IblockSection;
import io.khasang.rtrail.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Map<String, String> getIblockSections(Iblock iblock) {

        List<IblockSection> iblockSectionList = iblockSectionDao.getList(iblock);

        Map<String, String> sections = new HashMap<>();
        for (IblockSection iblockSection : iblockSectionList) {
            sections.put("/" + iblock.getCode() + "/" + iblockSection.getCode(), iblockSection.getName());
        }

        return sections;
    }

    @Override
    public IblockSection getIblockSectionByCode(Iblock iblock, String code) {
        return iblockSectionDao.getByCode(iblock, code);
    }

    @Override
    public Map<String, String> getIblockElements(Iblock iblock, IblockSection iblockSection) {

        List<IblockElement> iblockElementList = iblockElementDao.getList(iblock, iblockSection);

        Map<String, String> elements = new HashMap<>();
        for (IblockElement iblockElement : iblockElementList) {
            elements.put("/" + iblock.getCode() + "/" + iblockSection.getCode() + "/" + iblockElement.getCode(), iblockElement.getName());
        }

        return elements;
    }

    @Override
    public IblockElement getIblockElementByCode(Iblock iblock, IblockSection iblockSection, String elementCode) {
        return iblockElementDao.getByCode(iblock, iblockSection, elementCode);
    }


}
