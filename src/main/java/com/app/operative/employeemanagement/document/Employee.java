package com.app.operative.employeemanagement.document;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Employee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String name;
	private String designation;
	private String city;
	private double salary;

	public Employee() {
	}

	public Employee(String name, String designation, String city, double salary) {

		this.name = name;
		this.designation = designation;
		this.city = city;
		this.salary = salary;
	}

	public Employee(String id, String name, String designation, String city, double salary) {
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.city = city;
		this.salary = salary;
	}

	public String getid() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", designation=" + designation + ", city=" + city + ", salary="
				+ salary + "]";
	}

}
