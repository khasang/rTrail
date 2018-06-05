package io.khasang.rtrail.controller;

import io.khasang.rtrail.model.CreateTable;
import io.khasang.rtrail.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// http://localhost:8080
public class AppController {
    @Autowired
    @Qualifier("main")
    private Message message;

    @Autowired
    private CreateTable createTable;

    @RequestMapping("/")
    public String getHelloPage() {
        return "index";
    }

    @RequestMapping("/create")
    public String getCreateTableStatus(Model model) {
        model.addAttribute("status", createTable.createTableStatus());
        return "create";
    }

 /*   @RequestMapping(value = "/get/name/{name}", method = RequestMethod.GET)
    public String getCatByName(@PathVariable("name") String name, Model model) {
        model.addAttribute("info", createTable.getCatByName(name));
        return "info";
    }

    @RequestMapping(value = "/get/id/{id}", method = RequestMethod.GET)
    public String getCatById(@PathVariable("id") int id, Model model) {
        model.addAttribute("info", createTable.getCatById(id));
        return "info";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteCatById(@PathVariable("id") int id, Model model) {
        model.addAttribute("info", createTable.deleteCatById(id));
        return "info";
    }

    @RequestMapping(value = "/update/id/{id}/name/{name}", method = RequestMethod.GET)
    public String updateCatNameById(@PathVariable("id") int id, @PathVariable("name") String name, Model model) {
        model.addAttribute("info", createTable.updateCatNameById(id, name));
        return "info";
    }

    @RequestMapping(value = "/add/{id}/{name}/{description}/{colorId}", method = RequestMethod.GET)
    public String addCat(@PathVariable("id") int id, @PathVariable("name") String name,
                         @PathVariable("description") String description, @PathVariable("colorId") int colorId, Model model) {
        model.addAttribute("info", createTable.addCat(new CatForJdbcInfo(id, name, description, colorId)));
        return "info";
    }

    @RequestMapping(value = "/get/color/{colorName}", method = RequestMethod.GET)
    public String getCatByColor(@PathVariable("colorName") String colorName, Model model) {
        model.addAttribute("info", createTable.getCatByColorName(colorName));
        return "info";
    }

    @RequestMapping(value = "/password/{password}", method = RequestMethod.GET)
    public String getPasswordByEncode(@PathVariable("password") String password, Model model) {
        model.addAttribute("password", password);
        model.addAttribute("encodePassword", new BCryptPasswordEncoder().encode(password));
        return "password";
    }*/
}
