package com.example.spring_app1_demo.service;



import com.example.spring_app1_demo.entity.Employee;
import com.example.spring_app1_demo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void addEmployee(Employee employee) {
        repository.save(employee);
    }

    public Employee getEmployee(Long id) {
        return repository.findById(id);
    }

    public List<Employee> getEmployees(){
        return repository.findEmployees();
    }

    public List<Employee> getEmployeesByDept(String dept) {
        return repository.findByDepartment(dept);
    }

    public List<Employee> getEmployeesByName(String name) {
        return repository.findByName(name);
    }



    @Transactional
    public void removeEmployee(Long id) {
        Employee emp = repository.findById(id);
        if (emp != null) {
            repository.delete(emp);
        }
    }
}
