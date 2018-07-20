package com.app.operative.employeemanagement.test;

import org.springframework.boot.test.context.SpringBootTest;

//@RunWith(PowerMockRunner.class)
@SpringBootTest
public class EmployeeServiceImplTest  {

	
	/*private EmployeeServiceImpl employeeServiceImpl;
	private final MongoClient mongoClient = new Fongo("employeeRepository").getMongo();
	private final MongoTemplate mongoTemplate = new MongoTemplate(mongoClient, "employeeRepository");
	private EmployeeRepository mongoConfig;

	@Before
	public void setUp() {
		employeeServiceImpl = new EmployeeServiceImpl();
		mongoConfig = createMock(EmployeeRepository.class);
		ReflectionTestUtils.setField(employeeServiceImpl, "employeeRepository", mongoConfig);

	}

	@Test
	public void loadProductTemplateTest() {

		when(mongoConfig.findAll())
		.thenReturn(Collections.emptyList());
		
		verify(employeeServiceImpl.getEmployee());
		//loadProductTemplate("ProductTemplateLocalLinear.json");

	}*/

}
