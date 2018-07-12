package com.app.operative.employeemanagement.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.operative.employeemanagement.controller.EmployeeController;
import com.app.operative.employeemanagement.document.Employee;
import com.app.operative.employeemanagement.exception.EmployeeException;
import com.app.operative.employeemanagement.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(String id){
		List<Employee> employeeList = employeeRepository.findAll();
		
		Employee employee = null;
		try {
			employee = employeeList.stream()
					.filter(emp -> emp.getid().equals(id))
					.collect(Collectors.toList()).get(0);
		} catch (Exception e) {
			try {
				throw new EmployeeException("Employee id doesn't exist in our database");
			} catch (EmployeeException e1) {
				logger.error("Error while getting data from invalid employee id", e1);
			}
		}
		return employee;
	}

	@Override
	public Employee getEmployeeByName(String name) {

		List<Employee> employeeList = employeeRepository.findAll();
		Employee employee = null;
		
		try {
			employee= employeeList.stream().filter(emp -> emp.getName().equals(name)).collect(Collectors.toList()).get(0);
		} catch (Exception e) {
			try {
				throw new EmployeeException("Employee name doesn't exist in our database");
			} catch (EmployeeException e1) {
				logger.error("Error while getting data from invalid employee id", e1);
			}
		}
		return employee;
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		return employeeRepository.save(emp);

	}

	@Override
	public void deleteEmployee(String id) {
		employeeRepository.deleteById(id);

	}

}
