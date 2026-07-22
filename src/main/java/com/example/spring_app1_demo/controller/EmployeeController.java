package com.example.spring_app1_demo.controller;


import com.example.spring_app1_demo.entity.Employee;
import com.example.spring_app1_demo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    public String addEmployee(@RequestBody Employee employee) {
        service.addEmployee(employee);
        return "Employee saved!";
    }

    @GetMapping("/msg")
    public String welcome() {
        return "Welcome!!";
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return service.getEmployee(id);
    }

    @GetMapping("/department/{dept}")
    public List<Employee> getEmployeesByDept(@PathVariable String dept) {
        return service.getEmployeesByDept(dept);
    }

    @GetMapping("/name/{name}")
    public List<Employee> getEmployeesByName(@PathVariable String name) {
        return service.getEmployeesByName(name);
    }

    @GetMapping("/")
    public List<Employee> getEmployees() {
        return service.getEmployees();
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        service.removeEmployee(id);
        return "Employee deleted!";
    }
}

