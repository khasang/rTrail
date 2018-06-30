package io.khasang.rtrail.controller;

import io.khasang.rtrail.annotation.CurrentUser;
import io.khasang.rtrail.dto.UserDTO;
import io.khasang.rtrail.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping(value = "/users/get/current", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public UserDetails getCurrentAuthorizedUser(@CurrentUser UserDetails userDetails) {
        return userDetails;
    }

    @RequestMapping(value = "/users/get/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<UserDetails> getAuthorizedUsers() {
        return adminService.getAuthorizedUsers();
    }

    @RequestMapping(value = "/users/get/role/{role}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<UserDetails> getAuthorizedUsersByRole(@PathVariable(value = "role") String role) {
        return adminService.getAuthorizedUsersByRole(role);
    }

    @RequestMapping(value = "/users/get/name/{name}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<UserDetails> getAuthorizedUsersByName(@PathVariable(value = "name") String name) {
        return adminService.getAuthorizedUsersByName(name);
    }

}