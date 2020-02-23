package com.codeinsyt.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.codeinsyt.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO {

	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOJPAImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	@Override
	public List<Employee> findAll() {
		
		Query theQuery = entityManager.createQuery("from Employee");
		
		List<Employee> employees = theQuery.getResultList();
		return employees;
	}

	@Override
	public Employee findById(long theId) {
		
		Employee employee = entityManager.find(Employee.class, theId);
		
		return employee;
	}

	@Override
	@Transactional
	public void save(Employee employee) {
		
		Employee dbEmployee = entityManager.merge(employee);
		
		//update with id from the db ... so we get the generated value
		employee.setId(dbEmployee.getId());

	}

	@Override
	@Transactional
	public void deleteById(long theId) {
		
		//query to delete employee with d
		Query theQuery = entityManager.createQuery("delete from Employee where id=:empID");
		
		//set parameter
		theQuery.setParameter("empID",theId);
		
		theQuery.executeUpdate();

	}

}
