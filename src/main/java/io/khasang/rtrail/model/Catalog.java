package io.khasang.rtrail.model;

import io.khasang.rtrail.dao.interfaces.IblockDao;
import io.khasang.rtrail.dao.interfaces.IblockElementDao;
import io.khasang.rtrail.dao.interfaces.IblockSectionDao;
import io.khasang.rtrail.entity.Iblock;
import io.khasang.rtrail.entity.IblockElement;
import io.khasang.rtrail.entity.IblockSection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Catalog {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private IblockDao iblockDao;

    @Autowired
    private IblockSectionDao iblockSectionDao;

    @Autowired
    private IblockElementDao iblockElementDao;


    public Catalog(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public Iblock getIblockByCode(String iblockCode) {
        return iblockDao.getIblockByCode(iblockCode);
    }


    public List<IblockSection> getSections(Iblock iblock) {
        return iblockSectionDao.listSections(iblock);
    }

    public IblockSection getSectionByCode(String sectionCode, Iblock iblock) {
        return iblockSectionDao.getSectionByCode(sectionCode, iblock);
    }

    public List<IblockElement> getElements(Iblock iblock, IblockSection iblockSection) {
        return iblockElementDao.listElements(iblock, iblockSection);

    }

    public IblockElement getElementByCode(String elementCode, Iblock iblock, IblockSection iblockSection) {
        return iblockElementDao.getElementByCode(elementCode, iblock, iblockSection);
    }

    public Map<String, String> getSectionsList(Iblock iblock) {

        Map<String, String> sections = new HashMap<>();
        List<IblockSection> iblockSections = this.getSections(iblock);
        for (IblockSection iblockSection : iblockSections) {
            sections.put("/" + iblock.getCode() + "/" + iblockSection.getCode(), iblockSection.getName());
        }

        return sections;
    }

    public Map<String, String> getElementsList(Iblock iblock, IblockSection iblockSection) {

        Map<String, String> elements = new HashMap<>();
        List<IblockElement> iblockElements = this.getElements(iblock, iblockSection);
        for (IblockElement iblockElement : iblockElements) {
            elements.put("/" + iblock.getCode() + "/" + iblockSection.getCode() + "/" + iblockElement.getCode(), iblockElement.getName());
        }

        return elements;
    }

    public void fillingCatalog() {
        Iblock iblock = new Iblock("Каталог товаров", "catalog", "Интернет магазин автотоваров");
        iblockDao.add(iblock);

        IblockSection iblockSection1 = new IblockSection("Видеорегистраторы", "videoregistratory", "Видеорегистраторы - это ...", iblock);
        IblockSection iblockSection2 = new IblockSection("Радар-детекторы", "radardetektory", "Радар-детекторы - это ...", iblock);
        IblockSection iblockSection3 = new IblockSection("Автохолодильники", "avtoholodilniki", "Автохолодильники - это ...", iblock);
        iblockSectionDao.add(iblockSection1);
        iblockSectionDao.add(iblockSection2);
        iblockSectionDao.add(iblockSection3);

        IblockElement iblockElement1 = new IblockElement("Видеорегистратор Artway AV-110", "videoregistrator-artway-AV-110", "Видеорегистратор Artway AV-110 предназначен для ...", iblock, iblockSection1);
        IblockElement iblockElement2 = new IblockElement("Видеорегистратор Prestigio RoadRunner 325", "videoregistrator-prestigio-roa", "Видеорегистратор Prestigio RoadRunner 325 предназначен для ...", iblock, iblockSection1);
        IblockElement iblockElement3 = new IblockElement("Радар-детектор Artway RD-516", "radar-detektor-artway-RD-516", "Радар-детектор Artway RD-516 предназначен для ...", iblock, iblockSection2);
        IblockElement iblockElement4 = new IblockElement("Радар-детектор Sho-Me 520 STR", "radar-detektor-sho-me-520-STR", "Радар-детектор Sho-Me 520 STR предназначен для ...", iblock, iblockSection2);
        IblockElement iblockElement5 = new IblockElement("Автохолодильник Starwind CF-123", "avtoholodilnik-starwind-CF-123", "Автохолодильник Starwind CF-123 предназначен для ...", iblock, iblockSection3);
        iblockElementDao.add(iblockElement1);
        iblockElementDao.add(iblockElement2);
        iblockElementDao.add(iblockElement3);
        iblockElementDao.add(iblockElement4);
        iblockElementDao.add(iblockElement5);

        // todo generation translit

    }
}
