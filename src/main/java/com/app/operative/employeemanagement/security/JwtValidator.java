package com.app.operative.employeemanagement.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.app.operative.employeemanagement.document.Employee;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtValidator {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private String secret = "youtube";

	public Employee validate(String token) {

		Employee employee = null;
		try {
			Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();

			employee = new Employee();

			employee.setName(body.getSubject());
			employee.setCity((String) body.get("city"));
			employee.setSalary(Double.parseDouble((String) body.get("salary")));
			employee.setDesignation((String) body.get("designation"));
		} catch (Exception e) {
			logger.info("{}", e.getMessage());
		}

		return employee;
	}
}
