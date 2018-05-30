package io.khasang.rtrail.controller;

import io.khasang.rtrail.entity.catalog.Iblock;
import io.khasang.rtrail.entity.catalog.IblockElement;
import io.khasang.rtrail.entity.catalog.IblockSection;
import io.khasang.rtrail.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/catalog")
public class CatalogController {

    private String catalogCode = "catalog";

    @Autowired
    private CatalogService catalogService;

    @RequestMapping(value = "/")
    public String getCatalog(Model model) {

        Iblock iblock = catalogService.getIblockByCode(catalogCode);
        if (iblock == null) {
            return "catalogCreate";
        }

        model.addAttribute("title", iblock.getName());
        model.addAttribute("h1", iblock.getName());
        model.addAttribute("text", iblock.getDescription());
        model.addAttribute("links", catalogService.getIblockSections(iblock));
        model.addAttribute("back", "/");

        return "catalog";
    }

    @RequestMapping(value = "/fill")
    public String fillCatalog(Model model) {

        Iblock checkIblock = catalogService.getIblockByCode(catalogCode);
        if(checkIblock == null) {

            Iblock iblock = new Iblock("Каталог товаров", "catalog", "Интернет магазин автотоваров");
            catalogService.addIblock(iblock);

            IblockSection iblockSection1 = new IblockSection("Видеорегистраторы", "videoregistratory", "Видеорегистраторы - это ...", iblock);
            IblockSection iblockSection2 = new IblockSection("Радар-детекторы", "radardetektory", "Радар-детекторы - это ...", iblock);
            IblockSection iblockSection3 = new IblockSection("Автохолодильники", "avtoholodilniki", "Автохолодильники - это ...", iblock);
            catalogService.addIblockSection(iblockSection1);
            catalogService.addIblockSection(iblockSection2);
            catalogService.addIblockSection(iblockSection3);

            IblockElement iblockElement1 = new IblockElement("Видеорегистратор Artway AV-110", "videoregistrator-artway-AV-110", "Видеорегистратор Artway AV-110 предназначен для ...", iblock, iblockSection1);
            IblockElement iblockElement2 = new IblockElement("Видеорегистратор Prestigio RoadRunner 325", "videoregistrator-prestigio-roa", "Видеорегистратор Prestigio RoadRunner 325 предназначен для ...", iblock, iblockSection1);
            IblockElement iblockElement3 = new IblockElement("Радар-детектор Artway RD-516", "radar-detektor-artway-RD-516", "Радар-детектор Artway RD-516 предназначен для ...", iblock, iblockSection2);
            IblockElement iblockElement4 = new IblockElement("Радар-детектор Sho-Me 520 STR", "radar-detektor-sho-me-520-STR", "Радар-детектор Sho-Me 520 STR предназначен для ...", iblock, iblockSection2);
            IblockElement iblockElement5 = new IblockElement("Автохолодильник Starwind CF-123", "avtoholodilnik-starwind-CF-123", "Автохолодильник Starwind CF-123 предназначен для ...", iblock, iblockSection3);
            catalogService.addIblockElement(iblockElement1);
            catalogService.addIblockElement(iblockElement2);
            catalogService.addIblockElement(iblockElement3);
            catalogService.addIblockElement(iblockElement4);
            catalogService.addIblockElement(iblockElement5);


            model.addAttribute("info", "Каталог заполнен");
        } else {
            model.addAttribute("info", "Каталог уже был заполнен");
        }

        return "catalogFill";
    }

    @RequestMapping(value = "/{sectionCode}", method = RequestMethod.GET)
    public String getCatalogSection(@PathVariable("sectionCode") String sectionCode, Model model) {

        Iblock iblock = catalogService.getIblockByCode(catalogCode);
        IblockSection iblockSection = catalogService.getIblockSectionByCode(iblock, sectionCode);
        if (iblockSection == null) {
            return "404";
        }

        model.addAttribute("title", iblockSection.getName());
        model.addAttribute("h1", iblockSection.getName());
        model.addAttribute("text", iblockSection.getDescription());
        model.addAttribute("links", catalogService.getIblockElements(iblock, iblockSection));
        model.addAttribute("back", "/" + iblock.getCode() + "/");

        return "catalog";
    }

    @RequestMapping(value = "/{sectionCode}/{elementCode}", method = RequestMethod.GET)
    public String getCatalogElement(@PathVariable("sectionCode") String sectionCode, @PathVariable("elementCode") String elementCode, Model model) {

        Iblock iblock = catalogService.getIblockByCode(catalogCode);
        IblockSection iblockSection = catalogService.getIblockSectionByCode(iblock, sectionCode);
        IblockElement iblockElement = catalogService.getIblockElementByCode(iblock, iblockSection, elementCode);
        if (iblockElement == null) {
            return "404";
        }

        model.addAttribute("title", iblockElement.getName());
        model.addAttribute("h1", iblockElement.getName());
        model.addAttribute("text", iblockElement.getDescription());
        model.addAttribute("back", "/" + iblock.getCode() + "/" + iblockSection.getCode());

        return "catalog";
    }
}
