package com.app.operative.employeemanagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.operative.employeemanagement.document.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String>{

	/*public Employee findByName(String name);

	public Optional<Employee> findById(String id);*/
}
