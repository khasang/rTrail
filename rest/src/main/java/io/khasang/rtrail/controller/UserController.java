package io.khasang.rtrail.controller;

import io.khasang.rtrail.dto.UserDTO;
import io.khasang.rtrail.entity.User;
import io.khasang.rtrail.service.UserService;
import io.khasang.rtrail.service.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * controller for REST CRUD services
 * provide registration and login page for validation
 *
 * @author Ilya Bogachev
 * @since 22.06.2018
 */
@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public UserDTO addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public UserDTO updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public UserDTO getUserById(@PathVariable(value = "id") String id) {
        return userService.getUserById(Long.parseLong(id));
    }

    @RequestMapping(value = "/get/name/{username}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<UserDTO> getUserByName(@PathVariable(value = "username") String username) {
        return userService.getUserByName(username);
    }

    @RequestMapping(value = "/get/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<UserDTO> getUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
    @ResponseBody
    public UserDTO deleteUser(@RequestParam(value = "id") String id) {
        return userService.deleteUser(Long.parseLong(id));
    }

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

        return "redirect:/helloPage";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Your email and password is invalid");
        }

        if (logout != null) {
            model.addAttribute("message", "You have been logged out successfully");
        }

        return "login";
    }
}
