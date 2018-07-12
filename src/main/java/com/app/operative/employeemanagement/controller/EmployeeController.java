package com.app.operative.employeemanagement.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.operative.employeemanagement.document.Employee;
import com.app.operative.employeemanagement.service.EmployeeService;

@RestController
@RequestMapping("/rest/employee")
public class EmployeeController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(method = RequestMethod.GET, value = "/all")
	public List<Employee> getAllEmployee() {
		logger.info("Getting all employee records ");
		return employeeService.getEmployee();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/findbyid/{id}")
	public Employee getEmployeeById(@PathVariable String id)  {
		logger.info("Getting employee record by using employee id ");
		return employeeService.getEmployeeById(id);

	}

	@RequestMapping(method = RequestMethod.GET, value = "/findbyname/{name}")
	public Employee getEmployeeByName(@PathVariable String name) {
		logger.info("Retriving employee record by using employee name -{} ",name);
		return  employeeService.getEmployeeByName(name);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/addemployee")
	public Employee addEmployee(@RequestBody Employee employee) {
		logger.info("Adding  employee into database ");
		return employeeService.addEmployee(employee);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/updateemployee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		logger.info("updating employee");
		return employeeService.updateEmployee(employee);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteemployee/{id}")
	public void deleteEmployee(@PathVariable String id) {
		logger.info("Deleting employee by using id ");
		employeeService.deleteEmployee(id);
	}

}
