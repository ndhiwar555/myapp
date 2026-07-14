package com.example.spring_app1_demo;

import com.example.spring_app1_demo.entity.Employee;
import com.example.spring_app1_demo.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@SpringBootApplication
public class SpringApp1DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringApp1DemoApplication.class, args);
	}

    @Autowired
    private EmployeeService service;

    @PostConstruct
    public void init() {
        Employee employee1 = new Employee();
        employee1.setName("John Doe");
        employee1.setDepartment("Engineering");
        service.addEmployee(employee1);
    }
}
