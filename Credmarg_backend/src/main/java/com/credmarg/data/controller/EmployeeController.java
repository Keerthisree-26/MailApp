package com.credmarg.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.credmarg.data.model.Employee;
import com.credmarg.data.service.EmployeeService;
@CrossOrigin(origins="http://localhost:3000")
@RestController

public class EmployeeController {
	   @Autowired
	    private EmployeeService employeeService;

	    @PostMapping("/saveEmployee")
	    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
	        Employee savedEmployee = employeeService.saveEmployee(employee);
	        return ResponseEntity.ok(savedEmployee);
	    }

	    @GetMapping("/getEmployees")
	    public ResponseEntity<List<Employee>> getAllEmployees() {
	        return ResponseEntity.ok(employeeService.getAllEmployees());
	    }
}
