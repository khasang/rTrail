package io.khasang.rtrail.dao.impl;

import io.khasang.rtrail.dao.EmployeeDao;
import io.khasang.rtrail.entity.Employee;

public class EmployeeDaoImpl extends BasicDaoImpl<Employee> implements EmployeeDao {
    public EmployeeDaoImpl(Class<Employee> entityClass) {
        super(entityClass);
    }
}
