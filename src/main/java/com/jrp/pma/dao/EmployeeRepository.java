package com.jrp.pma.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.jrp.pma.entities.Employee;
import com.jrp.pma.entities.Project;

//Methods Inside Interface doesn't have have method body
public interface EmployeeRepository extends CrudRepository<Employee,Long> {
  
	@Override
	public List<Employee> findAll();
}
