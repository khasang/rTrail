package io.khasang.rtrail.controller;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import io.khasang.rtrail.model.Cat;
import io.khasang.rtrail.model.CreateTable;
import io.khasang.rtrail.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@ComponentScan("io.khasang.rtrail")
@EnableWebMvc
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

    @RequestMapping(value = "/update/{name}/setColor={colorId}", method = RequestMethod.GET)
    public String updateColorofCats(@PathVariable("name") String name, @PathVariable("colorId") int id, Model model) {
        model.addAttribute("info", createTable.updateColorCat(id, name));
        return "changeColor";
    }

    @RequestMapping("/showAll")
    public String showAllCats(Model model) {
        model.addAttribute("status", createTable.showAllCats());
        return "create";
    }

    @RequestMapping(value = "/show/{color}", method = RequestMethod.GET)
    public String showCatsWithColor(@PathVariable("color") String color, Model model) {
        model.addAttribute("info", createTable.showAllCatsWithColor(color));
        return "info";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteCatById(@PathVariable("id") int id, Model model) {
        model.addAttribute("info", createTable.deleteCatById(id));
        return "info";
    }

    @RequestMapping(value = "/add/{id}/{name}/{description}/{colorId}", method = RequestMethod.GET)
    public String addCat(@PathVariable("id") int id, @PathVariable("name") String name,
                         @PathVariable("description") String description, @PathVariable("colorId") int colorId, Model model) {
        model.addAttribute("info", createTable.insertIntoCat(new Cat(id,name,description,colorId)));
        return "info";
    }

    @RequestMapping(value = "/password/{password}",method = RequestMethod.GET)
    public String getPasswordByEncode(@PathVariable("password") String password, Model model) {
        model.addAttribute("password", password);
        model.addAttribute("encodePassword", new BCryptPasswordEncoder().encode(password));
        return "password";
    }
}
