package com.app.operative.employeemanagement.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.operative.employeemanagement.document.Employee;
import com.app.operative.employeemanagement.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

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
	public Employee updateEmployee(int id, Employee employee) {

		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(String id) {
		//return employeeRepository.findById(id);
		List<Employee> employeeList = employeeRepository.findAll();
		return employeeList.stream()
				.filter(employee -> employee.getid() == id)
				.collect(Collectors.toList()).get(0);
		
		
	}

	@Override
	public Employee getEmployeeByName(String name) {
		List<Employee> employeeList = employeeRepository.findAll();

		return employeeList.stream()
				.filter(employee -> employee.getName().equals(name))
				.collect(Collectors.toList()).get(0);
	}
	
	@Override
	public Employee updateEmployee(Employee emp) {
		return employeeRepository.save(emp);
		/*List<Employee> employeeList = employeeRepository.findAll();
		Employee employee =  employeeList.stream()
		.filter(e -> e.getid() == emp.getid())
		.collect(Collectors.toList()).get(0);
		
		employee.setCity(emp.getCity());
		employee.setDesignation(emp.getDesignation());
		employee.setSalary(emp.getSalary());
		employee.setName(emp.getName());
		
		employeeRepository.save(employee);
		return employee;*/
	}

	@Override
	public void deleteEmployee(String id) {
		//EmployeeServiceImpl impl = new EmployeeServiceImpl();
		//employeeRepository.delete(impl.getEmployeeById(id));
		employeeRepository.deleteById(id);
		
	}

	

}
