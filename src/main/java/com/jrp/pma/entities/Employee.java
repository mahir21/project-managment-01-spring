package com.jrp.pma.entities;


import java.util.List;

import javax.annotation.processing.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

//Entity is specific mark to save pojo class object in database
@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private long employeeID;
	private String firstName;
	private String lastName;
    private String email;
    
    //Creating a foreign key in the project database
    //Many Employees Are Linked With One Project
    @ManyToOne( cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
    		fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    
    @JsonIgnore
	private List<Project> projects;
	
	//Creating a constructor without any field
	public Employee()
	{
		
	}
	
	public Employee( String firstName, String lastName, String email) {
		super();
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
    
	public long getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(long employeeID) {
		this.employeeID = employeeID;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public void setProjects(List<Project> projects) {
		// TODO Auto-generated method stub
		this.projects = projects;
		
	}

	
    
}
