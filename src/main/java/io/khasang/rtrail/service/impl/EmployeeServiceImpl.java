package io.khasang.rtrail.service.impl;

import io.khasang.rtrail.dao.EmployeeDao;
import io.khasang.rtrail.dto.EmployeeDTO;
import io.khasang.rtrail.entity.Employee;
import io.khasang.rtrail.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private EmployeeDTO employeeDTO;

    @Override
    public EmployeeDTO getEmployeeById(long id) {
        return employeeDTO.getEmployeeDTO(employeeDao.getById(id));
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeDao.create(employee);
    }
}
