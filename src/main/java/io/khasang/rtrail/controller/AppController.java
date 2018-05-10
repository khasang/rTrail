package io.khasang.rtrail.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// http://localhost:8080
public class AppController {

    @RequestMapping("/")
    public String getHelloPage(Model model){
        model.addAttribute("name", "World!");
        return "index";
    }

}
