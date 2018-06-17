package io.khasang.rtrail.controller;

import io.khasang.rtrail.model.CreateTable;
import io.khasang.rtrail.model.Message;
import io.khasang.rtrail.util.CheckText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.List;

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
    private CheckText checkText;

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

    @ResponseBody
    @RequestMapping(value = "/text/{text}", method = RequestMethod.GET)
    public String checkText(@PathVariable("text") String text) throws MalformedURLException {
        return checkText.checkWord(text);
    }

    @ResponseBody
    @RequestMapping(value = "/texts/{texts}", method = RequestMethod.GET)
    public String checkTexts(@PathVariable("texts") String texts) throws MalformedURLException {
        // ex: http://localhost:8080/texts/caats doogs
        return checkText.checkWords(Arrays.asList(texts.split(" ")));
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