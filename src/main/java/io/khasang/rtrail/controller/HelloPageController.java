package io.khasang.rtrail.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/helloPage")
public class HelloPageController {

    @RequestMapping
    public String rootPage(Model model) {

//        TODO Generate page attributes by URL
//        Page page = new Page("/helloPage");
//        model.addAllAttributes(page.getAttributes());

//        model.addAttribute("title", "Яндекс карта");
//        model.addAttribute("h1", "Яндекс карта");
//        model.addAttribute("breadcrumbs", "<ul class=\"breadcrumb\">\n" +
//                "    <li><a href=\"#\">Главная</a></li>\n" +
//                "    <li><a href=\"#\">Сервисы</a></li>\n" +
//                "    <li class=\"active\">Яндекс карта</li>\n" +
//                "</ul>");
//        model.addAttribute("textBody", "<p>На многих коммерческих сайтах есть контактная информация с местом " +
//                "расположения их оффиса. Иногда, это просто изображение со схемой проезда, но очень часто " +
//                "встречается использование Яндекс.Карт.</p>\n" +
//                "<div id=\"map\" style=\"width: 100%; height: 400px\"></div>");
//        model.addAttribute("topMenu", "верхнее меню");
//        model.addAttribute("leftMenu", "Левое меню");

        return "helloPage";
    }
}
