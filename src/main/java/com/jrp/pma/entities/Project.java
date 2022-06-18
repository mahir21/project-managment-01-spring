package com.jrp.pma.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="project_seq")
	private long projectId;
	
	private String name;
	
	private String stage; // NOTSTARTED, COMPLETED, INPROGRESS
	
	private String description1;
	
	
	private Date startDate;
	
	
	private Date endDate;
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
			   fetch = FetchType.LAZY)
	@JoinTable(name="project_employee",
				joinColumns=@JoinColumn(name="project_id"), 
				inverseJoinColumns= @JoinColumn(name="employee_id")
	)
	@JsonIgnore
private List<Employee> employees;

public Project()
{
	
};

public List<Employee> getEmployees() {
	return employees;
}

public void setEmployees(List<Employee> employees) {
	this.employees = employees;
}

public Project( String name, String stage, String description) {
	super();
	
	this.name = name;
	this.stage = stage;
	this.description1 = description;
}
private String description;


public long getProjectID() {
	return projectId;
}
public void setProjectID(long projectId) {
	this.projectId = projectId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getStage() {
	return stage;
}
public void setStage(String stage) {
	this.stage = stage;
}
public String getDescription() {
	return description1;
}
public void setDescription(String description) {
	this.description1 = description;
}

//How To Modify method addEmployee in the project
public void addEmployee(Employee emp1) {
	// TODO Auto-generated method stub
	if(employees == null)
	{
		employees = new ArrayList<>();
	}
	// add employees to arrayList if it is not null
	employees.add(emp1);
	
}


}
