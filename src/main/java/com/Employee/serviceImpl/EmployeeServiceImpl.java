package com.Employee.serviceImpl;

import com.Employee.Repository.EmployeeRepository;
import com.Employee.entity.Employee;
import com.Employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public String saveEmployee(Employee employee) {
        Employee saveEmployee = employeeRepository.save(employee);
        return "Employee detail saved";
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList;
    }

    @Override
    public Employee getEmployeeById(int id) {

        Employee empById = employeeRepository.findById(id).orElseThrow(()
                -> new NullPointerException("Employee id is not found" + id));
        return empById;
    }

    @Override
    public String DeleteById(int id) {
        employeeRepository.deleteById(id);
        return "Employee Deleted";
    }
}
