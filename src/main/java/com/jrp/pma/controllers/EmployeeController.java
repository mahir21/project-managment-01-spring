package com.jrp.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.entities.Employee;

//Create a employee Controller 
//How To Create a controller

//All the requestMapping will route from this controller
@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository empRepo;
  @RequestMapping
  public String displayEmployee(Model model)
  {
	  //List Employee empRepo.findAll();
	  List<Employee> employees = empRepo.findAll();
	  
	  
	  // binding the html pages and controller pages together
	  model.addAttribute("employees",employees);
	  
	  return "employee/list-employee";
  }
	
	
  @RequestMapping("/new")
  public String displayProjectForm(Model model)
  {
	  //Mapping a empty project to form
	  Employee aEmployee = new Employee();
	  
	  //I am using model addAttribute to connect pojo class and forming a object of the html tag
	 model.addAttribute("employee",aEmployee);
	 
	
	 
	 return "employee";
  }
  @PostMapping("/save1")
  public String postForm(Model model, Employee employee)
  {
	  empRepo.save(employee);
	  return "redirect:/home/new";
	  
  }
  //Post Method
 
	
}
