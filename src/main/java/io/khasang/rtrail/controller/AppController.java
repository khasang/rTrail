package io.khasang.rtrail.controller;

import io.khasang.rtrail.model.CreateTable;
import io.khasang.rtrail.model.Message;
import io.khasang.rtrail.util.CheckText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.MalformedURLException;

@Controller
// http://localhost:8080
public class AppController {
    @Autowired
    @Qualifier("main")
    private Message message;
    @Autowired
    private CheckText checkText;

    @Autowired
    private CreateTable createTable;

    @RequestMapping("/")
    public String getHelloPage() {
        return "index";
    }

    @RequestMapping(value = "/check/{word}", method = RequestMethod.GET)
    @ResponseBody
    public String checkTextIsCorrect(@PathVariable("word") String word) throws MalformedURLException {
        return checkText.checkWord(word);
    }

    @RequestMapping("/create")
    public String getCreateTableStatus(Model model) {
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

}
