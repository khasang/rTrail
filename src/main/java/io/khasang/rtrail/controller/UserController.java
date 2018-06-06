package io.khasang.rtrail.controller;

import io.khasang.rtrail.entity.User;
import io.khasang.rtrail.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * controller for REST CRUD services
 *
 * @author Ilya Bogachev
 * @since 06.06.2017=8
 */

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public User getUserById(@PathVariable(value = "id") String id) {
        return userService.getUserById(Long.parseLong(id));
    }

    @RequestMapping(value = "/get/{name}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<User> getUserByName(@PathVariable(value = "name") String name) {
        return userService.getUserByName(name);
    }

    @RequestMapping(value = "/get/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
    @ResponseBody
    public User deleteUser(@RequestParam(value = "id") String id) {
        return userService.deleteUser(Long.parseLong(id));
    }
}
