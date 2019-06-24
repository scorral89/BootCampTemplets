package com.st.studentProject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	private String adjName;
	
	public Student() {};
	
	public Student(String firstName, String lastName, String adjName) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.adjName = adjName;
	}
	public Long getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAdjName() {
		return adjName;
	}
	public void setAdjName(String adjName) {
		this.adjName = adjName;
	}
	
	
}
