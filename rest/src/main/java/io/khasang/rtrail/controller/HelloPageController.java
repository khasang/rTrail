package io.khasang.rtrail.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hellopage")
public class HelloPageController {

    @RequestMapping
    public String rootPage(Model model) {
        return "helloPage";
    }
}
