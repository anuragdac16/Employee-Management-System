package com.app.operative.employeemanagement.service.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.app.operative.employeemanagement.controller.EmployeeController;
import com.app.operative.employeemanagement.service.EmployeeServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeServiceImplTest {

	private MockMvc mockMvc;
	
	@InjectMocks
	private EmployeeController employeeController;
	
	@InjectMocks
	private EmployeeServiceImpl employeeServiceImpl;
	
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(employeeServiceImpl).build();
	}

	@Test
	public void testGetAll() throws Exception{
		mockMvc.perform( MockMvcRequestBuilders.get("/rest/employee/all"))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
}
