package com.app.operative.employeemanagement.controller;

import java.util.List;

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

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(method = RequestMethod.GET , value="/all")
	public List<Employee> getEmployee() {
		return employeeService.getEmployee();
	}

	@RequestMapping(method = RequestMethod.GET , value="/findbyid/{id}")
	public Employee getEmployeeById(@PathVariable String id) {
		return employeeService.getEmployeeById(id);
	}

	@RequestMapping(method = RequestMethod.GET , value="/findbyname/{name}")
	public Employee getEmployeeByName(@PathVariable String name) {
		return employeeService.getEmployeeByName(name);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/addemployee")
	public Employee addEmployee(@RequestBody Employee employee) {

		return employeeService.addEmployee(employee);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/updateemployee")
	public Employee updateEmployee(@RequestBody Employee employee) {

		return employeeService.updateEmployee(employee);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteemployee/{id}")
	public void deleteEmployee(@PathVariable String id) {
		employeeService.deleteEmployee(id);
	}

}
