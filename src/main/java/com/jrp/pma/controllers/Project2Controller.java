package com.jrp.pma.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.entities.Employee;
import com.jrp.pma.entities.Project;


@Controller

public class Project2Controller {
	
	//AutoWired and ProjectRepository is calculated inside the public class
	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository empRepo;

	
	//EmpRepo Is Connecting EmployeeRepository Values Together
	
	
	
	@GetMapping("/home")
	public String getProject(Model model)
	{   
		// It will return project/new-projects to get values of java
		//Connecting projects and Employees in the database value toether
		//Connecting List Of Projects Together
	   
		//List<Employee> employee = empRepo.findAll();
		// Adding the list of employee to model
		
		//model.addAttribute("allEmployee", employee);
		
		
		return "main/hello";
	}
	
	
	/*
	@GetMapping("/new1")
	public String displayProject(Model model)
	{
		//Creating Projects Using New Projects
		
		 //Model Attributes Employee
		 model.addAttribute("Employee",AEmployee);
		 
		return "project/new-projects";
	}
	*/
	
	@GetMapping("/project1")
	public String displayProjectForm(Model model) {
		
		Project aProject = new Project();
		List<Employee> employees = empRepo.findAll();
		model.addAttribute("project", aProject);
		model.addAttribute("allEmployees",employees);
		
		return "projects/new-projects";
	}
	
	@GetMapping("/Employee")
	public String displayEmployee()
	{
		// It will return project/new-projects to get values of java
		return "employee/employee";
	}
	
	
	
	

}
