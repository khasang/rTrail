package io.khasang.rtrail.controller;

import io.khasang.rtrail.model.CreateTable;
import io.khasang.rtrail.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    public String getHelloPage(Model model){
        model.addAttribute("name", "World!");
        return "index";
    }

    @RequestMapping(value = "/get/{name}", method = RequestMethod.GET)
    public String getCatByName(@PathVariable("name") String name, Model model) {
        model.addAttribute("info", createTable.getDataFromBD(name));
        return "info";
    }


}
