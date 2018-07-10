package com.app.operative.employeemanagement.service;

import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.app.operative.employeemanagement.controller.EmployeeController;

@RunWith(SpringRunner.class)
public class EmployeeServiceImplTest {

	private MockMvc mockMvc;

	@MockBean
	private EmployeeController employeeController;

	@MockBean
	private EmployeeServiceImpl employeeService;

	@Before
	public void setUp() throws Exception {
		
		mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
	}
	
	@Test
	public void testGetEmployee() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/rest/employee/all"))
		.andExpect(status().isOk());
	}

	@Test
	public void testAddEmployee() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/rest/employee/addemployee")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.*", Matchers.hasSize(6)));
	}

	@Test
	public void testUpdateEmployeeIntEmployee() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEmployeeById() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/rest/employee/findbyid/1"))
		.andExpect(status().isOk());
	}

	@Test
	public void testGetEmployeeByName() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/rest/employee/findbyname/{name}"))
		.andExpect(status().isOk());
	}

	@Test
	public void testUpdateEmployeeEmployee() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteEmployee() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/rest/employee/deleteemployee/{id}"))
		.andExpect(status().isOk());
	}

}
