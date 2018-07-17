package com.app.operative.employeemanagement.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.app.operative.employeemanagement.document.Employee;
import com.app.operative.employeemanagement.document.ErrorDetails;
import com.app.operative.employeemanagement.exception.EmployeeException;
import com.app.operative.employeemanagement.exception.EmployeeNotFoundException;
import com.app.operative.employeemanagement.service.EmployeeService;

@ControllerAdvice
public class EmployeeControllerAdvice extends ResponseEntityExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeControllerAdvice.class);

	@Autowired
	private EmployeeService employeeService;

	@ExceptionHandler(EmployeeException.class)
	public final ResponseEntity<ErrorDetails> employeeNotFoundException(EmployeeException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	public List<Employee> getAllEmployee() {
		logger.info("Getting all employee records from controller advicer");
		List<Employee> employees = employeeService.getEmployee();
		if (employees.isEmpty()) {
			EmployeeNotFoundException e = new EmployeeNotFoundException("Employee record is empty ");
			logger.error("List of Employee Record is empty ", e);
			throw e;
		}
		return employees;

	}

	public Employee getEmployeeById(@PathVariable String id) {
		logger.info("Getting employee record by using employee id {} from controller advicer", id);
		Employee employee = employeeService.getEmployeeById(id);
		if (employee == null) {
			EmployeeNotFoundException e = new EmployeeNotFoundException("employee id : " + id +"  not found");
			logger.error("Employee not found", e);
			throw e;
		}
		return employee;

	}

	public Employee getEmployeeByName(@PathVariable String name) {
		logger.info("Retriving employee record by using employee name -{} from controller advicer", name);
		Employee employee = employeeService.getEmployeeByName(name);
		if (employee == null) {
			EmployeeNotFoundException e = new EmployeeNotFoundException("employee name : " + name+"  not found");
			logger.error("Employee not found", e);
			throw e;
		}
		return employee;
	}

	public Employee addEmployee(@RequestBody Employee employee) {
		logger.info("Adding  employee into database from controller advisor");
		return employeeService.addEmployee(employee);
	}

	public Employee updateEmployee(@RequestBody Employee employee) {
		logger.info("updating employee from controller advisor");
		return employeeService.updateEmployee(employee);
	}

	public void deleteEmployee(@PathVariable String id) {
		logger.info("Deleting employee by using id  from controller advisor {}" ,id);
		employeeService.deleteEmployee(id);
	}

}
