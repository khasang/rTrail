package io.khasang.rtrail.controller;

import io.khasang.rtrail.dto.IblockDTO;
import io.khasang.rtrail.dto.IblockElementDTO;
import io.khasang.rtrail.dto.IblockSectionDTO;
import io.khasang.rtrail.entity.catalog.Iblock;
import io.khasang.rtrail.entity.catalog.IblockElement;
import io.khasang.rtrail.entity.catalog.IblockSection;
import io.khasang.rtrail.service.CatalogService;
import io.khasang.rtrail.service.Menu;
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
    private IblockDTO iblockDTO;

    @Autowired
    private CatalogService catalogService;

    @RequestMapping(value = "/")
    public String getCatalog(Model model) {

        IblockDTO iblockDTO = catalogService.getIblockByCode(catalogCode);
        if (iblockDTO == null) {
            return "catalogCreate";
        }

        model.addAttribute("title", iblockDTO.getName());
        model.addAttribute("h1", iblockDTO.getName());
        model.addAttribute("breadcrumbs", catalogService.getBreadcrumbs(iblockDTO, null, null));
        model.addAttribute("leftMenu", catalogService.getMenu(iblockDTO, null, null));
        model.addAttribute("text", iblockDTO.getDescription());
        model.addAttribute("back", "/");

        return "catalog";
    }

    @RequestMapping(value = "/fill")
    public String fillCatalog(Model model) {

        IblockDTO checkIblock = catalogService.getIblockByCode(catalogCode);
        if (checkIblock == null) {

            catalogService.fillCatalog();
            model.addAttribute("info", "Каталог заполнен");
        } else {
            model.addAttribute("info", "Каталог уже был заполнен");
        }

        return "catalogFill";
    }

    @RequestMapping(value = "/{sectionCode}", method = RequestMethod.GET)
    public String getCatalogSection(@PathVariable("sectionCode") String sectionCode, Model model) {

        IblockDTO iblockDTO = catalogService.getIblockByCode(catalogCode);
        IblockSectionDTO iblockSectionDTO = catalogService.getIblockSectionByCode(iblockDTO, sectionCode);
        if (iblockSectionDTO == null) {
            return "404";
        }

        model.addAttribute("title", iblockSectionDTO.getName());
        model.addAttribute("h1", iblockSectionDTO.getName());
        model.addAttribute("breadcrumbs", catalogService.getBreadcrumbs(iblockDTO, iblockSectionDTO, null));
        model.addAttribute("leftMenu", catalogService.getMenu(iblockDTO, iblockSectionDTO, null));
        model.addAttribute("text", iblockSectionDTO.getDescription());
        model.addAttribute("back", "/" + iblockDTO.getCode() + "/");

        return "catalog";
    }

    @RequestMapping(value = "/{sectionCode}/{elementCode}", method = RequestMethod.GET)
    public String getCatalogElement(@PathVariable("sectionCode") String sectionCode, @PathVariable("elementCode") String elementCode, Model model) {

        IblockDTO iblockDTO = catalogService.getIblockByCode(catalogCode);
        IblockSectionDTO iblockSectionDTO = catalogService.getIblockSectionByCode(iblockDTO, sectionCode);
        IblockElementDTO iblockElementDTO = catalogService.getIblockElementByCode(iblockDTO, iblockSectionDTO, elementCode);
        if (iblockElementDTO == null) {
            return "404";
        }

        model.addAttribute("title", iblockElementDTO.getName());
        model.addAttribute("h1", iblockElementDTO.getName());
        model.addAttribute("breadcrumbs", catalogService.getBreadcrumbs(iblockDTO, iblockSectionDTO, iblockElementDTO));
        model.addAttribute("leftMenu", catalogService.getMenu(iblockDTO, iblockSectionDTO, iblockElementDTO));
        model.addAttribute("text", iblockElementDTO.getDescription());
        model.addAttribute("back", "/" + iblockDTO.getCode() + "/" + iblockSectionDTO.getCode());

        return "catalog";
    }
}
