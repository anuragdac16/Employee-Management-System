package com.app.operative.employeemanagement.service;

import java.util.List;

import com.app.operative.employeemanagement.document.Employee;

public interface EmployeeService {

	public List<Employee> getEmployee();
	public Employee addEmployee(Employee employee);
	public Employee updateEmployee(int id , Employee employee);
	public Employee getEmployeeById(String id);
	public Employee updateEmployee(Employee employee);
	public void deleteEmployee(String id);
	public Employee getEmployeeByName(String name);
	
}
