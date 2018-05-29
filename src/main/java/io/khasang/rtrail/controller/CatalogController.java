package io.khasang.rtrail.controller;

import io.khasang.rtrail.entity.catalog.Iblock;
import io.khasang.rtrail.entity.catalog.IblockSection;
import io.khasang.rtrail.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping(value = "/catalog")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    @RequestMapping(value = "/")
    public String getCatalog(Model model){

        Iblock iblock = catalogService.getIblockByCode("catalog");
        if (iblock == null) {
            return "404";
//            return "createCatalog";
        }

        model.addAttribute("title", iblock.getName());
        model.addAttribute("h1", iblock.getName());
        model.addAttribute("text", iblock.getDescription());
        model.addAttribute("sections", catalogService.getIblockSections(iblock));

        return "catalog";
    }

    @RequestMapping(value = "/{sectionCode}", method = RequestMethod.GET)
    public String getCatalogSection(@PathVariable("sectionCode") String sectionCode, Model model) {

        Iblock iblock = catalogService.getIblockByCode("catalog");
        IblockSection iblockSection = catalogService.getIblockSectionByCode(sectionCode);
        if (iblock == null || iblockSection == null) {
            return "404";
        }

        model.addAttribute("title", iblockSection.getName());
        model.addAttribute("h1", iblockSection.getName());
        model.addAttribute("text", iblockSection.getDescription());

        model.addAttribute("back", "/" + iblock.getCode() + "/");

        return "catalogSection";

//        Iblock iblock = catalog.getIblockByCode("catalog");
//        IblockSection iblockSection = catalog.getSectionByCode(sectionCode, iblock);
//        if (iblock == null || iblockSection == null) {
//            return "404";
//        }
//
//        model.addAttribute("title", iblockSection.getName());
//        model.addAttribute("h1", iblockSection.getName());
//        model.addAttribute("text", iblockSection.getDescription());
//        model.addAttribute("elements", catalog.getElementsList(iblock, iblockSection));
//        model.addAttribute("back", "/" + iblock.getCode() + "/");

//        return "catalogSection";

    }


//    @Autowired
//    private Catalog catalog;
//
//    @RequestMapping("/create")
//    public String createCatalog(Model model) {
//        String isEmpty = "";
//        Iblock iblock = catalog.getIblockByCode("catalog");
//        if (iblock == null) {
//            //return "404";
//            catalog.fillingCatalog(); // todo return flag filling
//            isEmpty = "Каталог был заполнен";
//        }else{
//            isEmpty = "Каталог не пуст";
//        }
//
//        model.addAttribute("isEmpty", isEmpty);
//
//        return "fillCatalog";
//    }
//
//    @RequestMapping("/")
//    public String getCatalog(Model model) {
//        Iblock iblock = catalog.getIblockByCode("catalog");
//        if (iblock == null) {
////            return "404";
//            return "createCatalog";
//
//        }
//
//        model.addAttribute("title", iblock.getName());
//        model.addAttribute("h1", iblock.getName());
//        model.addAttribute("text", iblock.getDescription());
//        model.addAttribute("sections", catalog.getSectionsList(iblock));
//
//        return "catalog";
//    }
//
//    @RequestMapping(value = "/{sectionCode}", method = RequestMethod.GET)
//    public String getCatalogSection(@PathVariable("sectionCode") String sectionCode, Model model) {
//
//        Iblock iblock = catalog.getIblockByCode("catalog");
//        IblockSection iblockSection = catalog.getSectionByCode(sectionCode, iblock);
//        if (iblock == null || iblockSection == null) {
//            return "404";
//        }
//
//        model.addAttribute("title", iblockSection.getName());
//        model.addAttribute("h1", iblockSection.getName());
//        model.addAttribute("text", iblockSection.getDescription());
//        model.addAttribute("elements", catalog.getElementsList(iblock, iblockSection));
//        model.addAttribute("back", "/" + iblock.getCode() + "/");
//
//        return "catalogSection";
//    }
//
//    @RequestMapping(value = "/{sectionCode}/{elementCode}", method = RequestMethod.GET)
//    public String getCatalogElement(@PathVariable("sectionCode") String sectionCode, @PathVariable("elementCode") String elementCode, Model model) {
//
//        Iblock iblock = catalog.getIblockByCode("catalog");
//        IblockSection iblockSection = catalog.getSectionByCode(sectionCode, iblock);
//        IblockElement iblockElement = catalog.getElementByCode(elementCode, iblock, iblockSection);
//        if (iblock == null || iblockSection == null || iblockElement == null) {
//            return "404";
//        }
//
//        model.addAttribute("title", iblockElement.getName());
//        model.addAttribute("h1", iblockElement.getName());
//        model.addAttribute("text", iblockElement.getDescription());
//        model.addAttribute("back", "/" + iblock.getCode() + "/" + iblockSection.getCode());
//
//        return "catalogElement";
//    }



}
