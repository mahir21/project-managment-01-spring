package com.jrp.pma.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.entities.Project;

@Controller

@RequestMapping("/project")
public class ProjectController {
	
	
	//We Are Going To Use proRepo Object To Save Our Employee Instance
	@Autowired
	ProjectRepository proRepo;
	
//new
	//It will directly save the getMapping to get
	//Using Model to add attributes in the project
	@GetMapping("/new1")
	public String displayForm(Model model)
	{
		//Creating a project instance to 
		Project aProject = new Project();
		
		
		//Connecting the project model with add attributes view
		model.addAttribute("project",aProject);
		return "projects/new-projects";
	}
	
	@GetMapping("/new2")
	public String helloUser()
	{
		return "Hello Mahir";
	}

	
	//Using PostMapping to add attributes to the model
	//PostMap will store out attributes in database
	
	//proRepo is saving the project
	@PostMapping("/save")
	public String createProject(Project project,Model model)
	{
		//It will prevent duplicate submission
		//proRepo.save(project);
		
		proRepo.save(project);
	
		return  "redirect:/project/new1";
	}
	

}


//Setting Up Controllers
//Request Mapping Url will display project

