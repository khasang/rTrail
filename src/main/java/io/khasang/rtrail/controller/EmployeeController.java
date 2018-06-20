package io.khasang.rtrail.controller;

import io.khasang.rtrail.dto.EmployeeDTO;
import io.khasang.rtrail.entity.Employee;
import io.khasang.rtrail.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Employee employee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public EmployeeDTO employee(@PathVariable(value = "id") String id) {
        return employeeService.getEmployeeById(Long.parseLong(id));
    }
}
