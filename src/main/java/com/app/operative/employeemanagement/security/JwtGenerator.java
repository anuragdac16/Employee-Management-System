package com.app.operative.employeemanagement.security;

import org.springframework.stereotype.Component;

import com.app.operative.employeemanagement.document.Employee;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtGenerator {


    public String generate(Employee employee) {


        Claims claims = Jwts.claims()
                .setSubject(employee.getName());
        claims.put("userId", String.valueOf(employee.getid()));
        claims.put("designation", employee.getDesignation());
        claims.put("city", employee.getCity());
        claims.put("name", employee.getName());
        claims.put("salary", employee.getSalary());


        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, "youtube")
                .compact();
    }
}
