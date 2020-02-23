package com.codeinsyt.springboot.cruddemo.dao;

import java.util.List;

import com.codeinsyt.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {
	//list employees
	public List<Employee> findAll();
	
	//get employee
	public Employee findById(long theId);
	
	//update employee
	public void save(Employee employer);
	
	//delete employee
	public void deleteById(long theId);
	
	
	

}
