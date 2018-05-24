package io.khasang.rtrail.controller;

import io.khasang.rtrail.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@ComponentScan("io.khasang.rtrail")
@EnableWebMvc
// http://localhost:8080
public class AppController {
    @Autowired
    @Qualifier("main")
    private Message message;

    @RequestMapping("/")
    public String getHelloPage(Model model){
        model.addAttribute("name", message.getInfo());
        return "index";
    }

}
