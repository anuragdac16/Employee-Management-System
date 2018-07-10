/*package com.app.operative.employeemanagement.repository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.app.operative.employeemanagement.document.Employee;
import com.app.operative.employeemanagement.repository.EmployeeRepository;

@EnableMongoRepositories(basePackageClasses= EmployeeRepository.class)
@Configuration
public class MongoDbConfig {
	
	@Bean
	CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository) {
		
	 	return strings -> {
			employeeRepository.save(new Employee( "Anurag", "developer", "Bangalore", 1000.00));
			//employeeRepository.save(new Employee( "Gupta", "developer", "Bangalore", 1000.00));
		};
		
	}
	
	

}
*/