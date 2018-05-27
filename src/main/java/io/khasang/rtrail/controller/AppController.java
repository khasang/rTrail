package io.khasang.rtrail.controller;

import io.khasang.rtrail.entity.Iblock;
import io.khasang.rtrail.entity.IblockElement;
import io.khasang.rtrail.entity.IblockSection;
import io.khasang.rtrail.model.Catalog;
import io.khasang.rtrail.model.CreateTable;
import io.khasang.rtrail.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.persistence.ManyToOne;
import java.util.*;

@Controller
@ControllerAdvice
// http://localhost:8080
public class AppController {
    @Autowired
    @Qualifier("main")
    private Message message;

    @Autowired
    private CreateTable createTable;

    @Autowired
    private Catalog catalog;

    @RequestMapping("/")
    public String getHelloPage(Model model) {
        model.addAttribute("name", message.getInfo());
        return "index"; // .jsp писать не надо
    }

    @RequestMapping("/create")
    public String getCreateStatus(Model model) {
        model.addAttribute("status", createTable.createTableStatus());
        return "create";
    }

//    @RequestMapping(value = "/get/{name}", method = RequestMethod.GET)
//    public String getCatByName(@PathVariable("name") String name, Model model) {
//        model.addAttribute("info", createTable.getCatByName(name));
//        return "info";
//    }

    @RequestMapping(value = "/password/{password}", method = RequestMethod.GET)
    public String getPasswordByEncode(@PathVariable("password") String password, Model model) {
        model.addAttribute("password", password);
        model.addAttribute("encodePassword", new BCryptPasswordEncoder().encode(password));
        return "password";
    }

    @RequestMapping("/catalog/create")
    public String createCatalog(Model model) {
        String isEmpty = "";
        Iblock iblock = catalog.getIblockByCode("catalog");
        if (iblock == null) {
            //return "404";
            catalog.fillingCatalog(); // todo return flag filling
            isEmpty = "Каталог был заполнен";
        }else{
            isEmpty = "Каталог не пуст";
        }

        model.addAttribute("isEmpty", isEmpty);

        return "fillCatalog";
    }

    @RequestMapping("/catalog/")
    public String getCatalog(Model model) {
        Iblock iblock = catalog.getIblockByCode("catalog");
        if (iblock == null) {
//            return "404";
            return "createCatalog";

        }

        model.addAttribute("title", iblock.getName());
        model.addAttribute("h1", iblock.getName());
        model.addAttribute("text", iblock.getDescription());
        model.addAttribute("sections", catalog.getSectionsList(iblock));

        return "catalog";
    }

    @RequestMapping(value = "/catalog/{sectionCode}", method = RequestMethod.GET)
    public String getCatalogSection(@PathVariable("sectionCode") String sectionCode, Model model) {

        Iblock iblock = catalog.getIblockByCode("catalog");
        IblockSection iblockSection = catalog.getSectionByCode(sectionCode, iblock);
        if (iblock == null || iblockSection == null) {
            return "404";
        }

        model.addAttribute("title", iblockSection.getName());
        model.addAttribute("h1", iblockSection.getName());
        model.addAttribute("text", iblockSection.getDescription());
        model.addAttribute("elements", catalog.getElementsList(iblock, iblockSection));
        model.addAttribute("back", "/" + iblock.getCode() + "/");

        return "catalogSection";
    }

    @RequestMapping(value = "/catalog/{sectionCode}/{elementCode}", method = RequestMethod.GET)
    public String getCatalogElement(@PathVariable("sectionCode") String sectionCode, @PathVariable("elementCode") String elementCode, Model model) {

        Iblock iblock = catalog.getIblockByCode("catalog");
        IblockSection iblockSection = catalog.getSectionByCode(sectionCode, iblock);
        IblockElement iblockElement = catalog.getElementByCode(elementCode, iblock, iblockSection);
        if (iblock == null || iblockSection == null || iblockElement == null) {
            return "404";
        }

        model.addAttribute("title", iblockElement.getName());
        model.addAttribute("h1", iblockElement.getName());
        model.addAttribute("text", iblockElement.getDescription());
        model.addAttribute("back", "/" + iblock.getCode() + "/" + iblockSection.getCode());

        return "catalogElement";
    }


    @ExceptionHandler(NoHandlerFoundException.class)
    public String handle(Exception ex) {
//        return "redirect:/404";
        return "404";
    }

    @RequestMapping(value = {"/404"}, method = RequestMethod.GET)
    public String NotFoudPage() {
        return "404";
    }

}


