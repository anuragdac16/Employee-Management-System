package com.app.operative.employeemanagement;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.app.operative.employeemanagement.controller.EmployeeController;
import com.app.operative.employeemanagement.service.EmployeeServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeemanagementApplicationTests {

	private MockMvc mockMvc;

	@MockBean
	private EmployeeController employeeController;

	@MockBean
	private EmployeeServiceImpl employeeService;

	@Before
	public void setUp() throws Exception {
		
		mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
		//mockMvc = MockMvcBuilders.standaloneSetup(employeeService).build();
	}

	@Test
	public void testGetAll() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.get("/rest/employee/all"))
				.andExpect(status().isOk());
	}

	@Test
	public void testGetById() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.get("/rest/employee/1"))
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
	public void contextLoads() {
	}

}
