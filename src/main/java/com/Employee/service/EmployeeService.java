package com.Employee.service;

import com.Employee.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public String saveEmployee(Employee employee);

    public List<Employee> getAllEmployee();

    public Employee getEmployeeById(int id);

    public String DeleteById(int id);
}
