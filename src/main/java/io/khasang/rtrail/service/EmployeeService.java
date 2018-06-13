package io.khasang.rtrail.service;

import io.khasang.rtrail.dto.EmployeeDTO;
import io.khasang.rtrail.entity.Employee;

public interface EmployeeService {
    Employee addEmployee(Employee employee);

    EmployeeDTO getEmployeeById(long id);
}
