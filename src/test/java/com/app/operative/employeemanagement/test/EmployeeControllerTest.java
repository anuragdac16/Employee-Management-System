package com.app.operative.employeemanagement.test;

import static org.hamcrest.CoreMatchers.is;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.app.operative.employeemanagement.controller.EmployeeController;
import com.app.operative.employeemanagement.controller.EmployeeControllerAdvice;
import com.app.operative.employeemanagement.document.Employee;
import com.app.operative.employeemanagement.service.EmployeeService;

@RunWith(SpringRunner.class)

@WebMvcTest(controllers=EmployeeController.class)
public class EmployeeControllerTest {
	@Autowired
	private MockMvc mockMvc; 

	@MockBean
	private EmployeeController employeeController; 

	@MockBean
	private EmployeeControllerAdvice employeeControllerAdvice; 
	@MockBean
	private EmployeeService employeeService; 

	// @Rule public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {

		mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
	}

	@Test
	public void testGetEmployee() throws Exception { 

		Employee employee = new Employee("10", "Suraj", "developer", "blr", 10000.0);
		List<Employee> list = new ArrayList<>();
		list.add(employee);
		employeeController.addEmployee(employee);
		when(employeeController.getAllEmployee()).thenReturn(list);

		mockMvc.perform(MockMvcRequestBuilders.get("/rest/employee/all")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();

		verify(employeeController).getAllEmployee();

	}

	@Test
	public void testAddEmployee() throws Exception {

		Employee employee = new Employee("10", "Suraj", "developer", "blr", 10000.0);
		when(employeeController.addEmployee(employee)).thenReturn(employee);

		mockMvc.perform(MockMvcRequestBuilders.post("/rest/employee/addemployee")
				.accept(MediaType.APPLICATION_JSON))
				.andReturn();

		assertEquals(employee.getName() ,employeeController.addEmployee(employee).getName());
		assertThat(employeeController.addEmployee(employee), is(notNullValue()));

	}

	@Test
	public void testGetEmployeeByName() throws Exception {

		Employee employee = new Employee("10", "Suraj", "developer", "blr", 10000.0);

		employeeController.addEmployee(employee);
		when(employeeController.getEmployeeByName(Mockito.anyString())).thenReturn(employee);

		mockMvc.perform(
				MockMvcRequestBuilders.get("/rest/employee/findbyname/Suraj")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();

		verify(employeeController).getEmployeeByName("Suraj");

	}

	@Test
	public void testGetEmployeeById() throws Exception {

		Employee employee = new Employee("10", "Suraj", "developer", "blr", 10000.0);

		employeeController.addEmployee(employee);
		when(employeeController.getEmployeeById(Mockito.anyString())).thenReturn(employee);

		mockMvc.perform(MockMvcRequestBuilders.get("/rest/employee/findbyname/10")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();

		verify(employeeController).getEmployeeByName("10");

	}

	@Test
	public void testUpdateEmployee() throws Exception {
		Employee employee = new Employee("10", "Suraj", "developer", "blr", 10000.0);

		employeeController.addEmployee(employee);
		when(employeeController.updateEmployee(employee)).thenReturn(employee);

		mockMvc.perform(MockMvcRequestBuilders.put("/rest/employee/updateemployee")
				.accept(MediaType.APPLICATION_JSON))
				.andReturn();

		assertEquals(employee.getName() ,employeeController.updateEmployee(employee).getName());
		assertThat(employeeController.updateEmployee(employee), is(notNullValue()));

	}

	@Test
	public void testDeleteEmployee() throws Exception {
		Employee employee = new Employee("10", "Suraj", "developer", "blr", 10000.0);

		employeeController.addEmployee(employee);
		mockMvc.perform(
				MockMvcRequestBuilders.delete("/rest/employee/deleteemployee/10")
				.accept(MediaType.APPLICATION_JSON))
				.andReturn();
		verify(employeeController).deleteEmployee("10");

	}

}
