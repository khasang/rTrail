package io.khasang.rtrail.controller;

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

    @RequestMapping(value = "/get/{name}", method = RequestMethod.GET)
    public String getCatByName(@PathVariable("name") String name, Model model) {
        model.addAttribute("info", createTable.getCatByName(name));
        return "info";
    }

    @RequestMapping(value = "/password/{password}", method = RequestMethod.GET)
    public String getPasswordByEncode(@PathVariable("password") String password, Model model) {
        model.addAttribute("password", password);
        model.addAttribute("encodePassword", new BCryptPasswordEncoder().encode(password));
        return "password";
    }

    @RequestMapping("/catalog/")
    public String getCatalog(Model model) {
        model.addAttribute("sections", catalog.getSections());
        return "catalog";
    }

    @RequestMapping(value = "/catalog/{section}", method = RequestMethod.GET)
    public String getCatalogSection(@PathVariable("section") String section, Model model) {
        Map<String, String> elements = catalog.getElements(section);
        if (elements == null) {
            return "404";
        }
        model.addAttribute("elements", elements);
        return "catalogSection";
    }

    @RequestMapping(value = "/catalog/{section}/{element}", method = RequestMethod.GET)
    public String getCatalogElement(@PathVariable("section") String section, @PathVariable("element") String element, Model model) {
        model.addAttribute("element", catalog.getElement(section, element));
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


