package io.khasang.rtrail.controller;

import io.khasang.rtrail.model.CreateTable;
import io.khasang.rtrail.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;

@Controller
@ControllerAdvice
// http://localhost:8080
public class AppController {
    @Autowired
    @Qualifier("main")
    private Message message;

    @Autowired
    private CreateTable createTable;

    @RequestMapping("/")
    public String getHelloPage() {
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


