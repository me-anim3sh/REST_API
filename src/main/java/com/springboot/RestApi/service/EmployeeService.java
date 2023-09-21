package com.springboot.RestApi.service;

import com.springboot.RestApi.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmploye(Employee employee);

    List<Employee> getAllEmployee();

    Employee getEmpByID(long id);

    Employee updateEmp(Employee employee, long id);
}
