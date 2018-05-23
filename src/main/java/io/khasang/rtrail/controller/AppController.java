package io.khasang.rtrail.controller;

import io.khasang.rtrail.model.CreateTable;
import io.khasang.rtrail.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
// http://localhost:8080
public class AppController {
    @Autowired
    @Qualifier("main")
    private Message message;



    @Autowired
    private CreateTable createTable;

    @RequestMapping("/")
    public String getHelloPage(Model model) {
        model.addAttribute("name", message.getInfo());
        return "index";
    }

    @RequestMapping("/create")
    public String getCreateTableStatus(Model model) {
        model.addAttribute("status", createTable.createTableStatus());
        return "create";
    }

    @RequestMapping(value = "/get/{name}", method = RequestMethod.GET)
    public String getCatByName(@PathVariable("name") String name, Model model) {
        model.addAttribute("info", createTable.getCatByName(name));
        return "info";
    }

    @RequestMapping(value = "/update/{description}/{id}", method = RequestMethod.GET)
    public String updateCatDescription(@PathVariable("description") String description, @PathVariable("id") int id, Model model) {
        model.addAttribute("update", createTable.updateCatDescription(description, id));
        return "update";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteCatById(@PathVariable("id") int id, Model model) {
        model.addAttribute("delete", createTable.deleteCatById(id));
        return "delete";
    }

    @RequestMapping(value = "/insert/{id}/{name}/{description}/{color_id}", method = RequestMethod.GET)
    public String insertNewCat(@PathVariable("id") int id, @PathVariable("name") String name, @PathVariable("description")
            String description, @PathVariable("color_id") int color_id, Model model) {
        model.addAttribute("insert", createTable.insertNewCat(id, name, description, color_id));
        return "insert";
    }

    @RequestMapping(value = "/join")
    public String joinTables(Model model) {
        model.addAttribute("join", createTable.joinTables());
        return "join";
    }

    @RequestMapping(value = "/innerselect/{catColor}", method = RequestMethod.GET)
    public String innerSelect(@PathVariable("catColor") String catColor, Model model) {
        model.addAttribute("innerSelect", createTable.innerSelect(catColor));
        return "innerSelect";
    }

    @RequestMapping(value = "/password/{password}", method = RequestMethod.GET)
    public String getPasswordByEncode(@PathVariable("password") String password, Model model){
        model.addAttribute("password", password);
        model.addAttribute("encodePassword", new BCryptPasswordEncoder().encode(password));
        return "password";
    }
}
