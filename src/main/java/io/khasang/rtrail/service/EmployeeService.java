package io.khasang.rtrail.service;

import io.khasang.rtrail.dto.EmployeeDTO;
import io.khasang.rtrail.entity.Employee;

public interface EmployeeService {

    /**
     * method for add employee
     *
     * @param employee = new employee
     * @return created employee
     */
    Employee addEmployee(Employee employee);

    /**
     * method for getting employee
     *
     * @param id - employee's id for getting
     * @return employee by id
     */
    EmployeeDTO getEmployeeById(long id);
}
