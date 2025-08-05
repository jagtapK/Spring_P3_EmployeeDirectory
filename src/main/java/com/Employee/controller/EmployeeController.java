package com.Employee.controller;

import com.Employee.entity.Employee;
import com.Employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/addEmployees")
    public ResponseEntity<String> addEmployees(@RequestBody List<Employee> employees) {

        employees.forEach(employee -> {
            System.err.println(employee);
            employeeService.saveEmployee(employee);
        });

        return new ResponseEntity<>("All employee data saved", HttpStatus.CREATED);
    }

    @GetMapping("/getAllEmployee")
    public ResponseEntity<List<Employee>> getAllEmployee() {
        List<Employee> emplist = employeeService.getAllEmployee();
        return new ResponseEntity<>(emplist, HttpStatus.OK);

    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Employee> empById(@PathVariable int id) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee != null) {
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/DeleteById/{id}")
    public ResponseEntity<String> DeleteById(@PathVariable int id){
      String emp =  employeeService.DeleteById(id);
      return new ResponseEntity<>(emp,HttpStatus.OK);
    }
}
