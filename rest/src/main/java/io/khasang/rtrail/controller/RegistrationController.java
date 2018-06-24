package io.khasang.rtrail.controller;

import io.khasang.rtrail.entity.User;
import io.khasang.rtrail.service.UserService;
import io.khasang.rtrail.service.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * provide registration and showLoginForm page for validation
 *
 * @author Ilya Bogachev
 * @since 23.06.2018
 */
@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String showRegistrationForm(Model model){
        User userFromFormRegistration = new User();
        model.addAttribute("user", userFromFormRegistration);
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("user") User userFromFormRegistration, BindingResult bindingResult, Model model){
        userValidator.validate(userFromFormRegistration, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.addUser(userFromFormRegistration);

        return "redirect:/hellopage";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginForm(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Your email and password is invalid");
        }

        if (logout != null) {
            model.addAttribute("message", "You have been logged out successfully");
        }

        return "login";
    }
}
