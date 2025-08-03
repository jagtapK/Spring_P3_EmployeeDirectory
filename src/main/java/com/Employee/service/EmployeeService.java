package com.Employee.service;

import com.Employee.entity.Employee;

import java.util.List;

public interface EmployeeService {

public String saveEmployee(Employee employee);

public List<Employee> getAllEmployee();
}
