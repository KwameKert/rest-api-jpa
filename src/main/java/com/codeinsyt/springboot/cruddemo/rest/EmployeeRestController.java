package com.codeinsyt.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeinsyt.springboot.cruddemo.entity.Employee;
import com.codeinsyt.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return this.employeeService.listEmployees();
	}
	
	@GetMapping("/employees/{employeeID}")
	public Employee getEmployee(@PathVariable int employeeID) {
		Employee theEmployee = this.employeeService.getEmployee(employeeID);
		
		if(theEmployee == null) {
			throw new RuntimeException("No employee found for - "+employeeID);
		}
		
		return theEmployee;
	}

	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		 employee.setId(0);
		 employeeService.save(employee);	
		 return employee;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		employeeService.save(theEmployee);
		return theEmployee;
	}
	
	@DeleteMapping("/employees/{employeeID}")
	public  String deleteEmployee(@PathVariable int employeeID) {
		Employee theEmployee = this.employeeService.getEmployee(employeeID);
		
		if(theEmployee == null) {
			throw new RuntimeException("Employee not found -"+employeeID);
		}
    	this.employeeService.deleteEmployee(employeeID);
		return "Deleted Employee id - "+employeeID;
	
	}
	
	
}
