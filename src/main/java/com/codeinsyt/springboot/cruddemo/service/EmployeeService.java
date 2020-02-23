package com.codeinsyt.springboot.cruddemo.service;

import java.util.List;

import com.codeinsyt.springboot.cruddemo.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> listEmployees();
	
	public Employee getEmployee(long id);
	
	public void save(Employee employee);
	
	public void deleteEmployee(long id);
	
	

}
