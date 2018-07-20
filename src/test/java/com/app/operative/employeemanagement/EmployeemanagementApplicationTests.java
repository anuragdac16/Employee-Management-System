package com.app.operative.employeemanagement;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.app.operative.employeemanagement.document.Employee;
import com.app.operative.employeemanagement.repository.EmployeeRepository;
import com.app.operative.employeemanagement.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeemanagementApplicationTests {

	@Autowired
	EmployeeService service;
	

	EmployeeRepository repository;

	@Before
	public void create()
	{
		repository=mock(EmployeeRepository.class);
		ReflectionTestUtils.setField(service, "employeeRepository", repository);
	}
	
	@Test
	public void contextLoads() {
		List<Employee> list=new ArrayList<>();
	
		Employee entity = new Employee("10","Suraj", "developer", "blr", 10000.0);
		list.add(entity);
		repository.save(entity);
		when(repository.findAll()).thenReturn(list);
		
		assertEquals(list.get(0).getid(), service.getEmployeeById("10").getid());
		
		verify(repository).findAll();
	}
		
	
}
