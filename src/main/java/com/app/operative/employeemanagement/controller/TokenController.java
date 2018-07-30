package com.app.operative.employeemanagement.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.operative.employeemanagement.document.Employee;
import com.app.operative.employeemanagement.security.JwtGenerator;

@RestController
public class TokenController {


    private JwtGenerator jwtGenerator;

    public TokenController(JwtGenerator jwtGenerator) {
        this.jwtGenerator = jwtGenerator;
    }

    
    @RequestMapping(method=RequestMethod.POST , value= "/token")
    public String generate(@RequestBody final Employee employee) {

        return jwtGenerator.generate(employee);

    }
}
