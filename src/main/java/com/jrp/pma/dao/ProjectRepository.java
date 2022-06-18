package com.jrp.pma.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jrp.pma.entities.Project;

public interface ProjectRepository extends CrudRepository<Project,Long> {
	
	//Why is this particular method required need to find out
	// Making it public so it is accessible from anywhere
	@Override
	public List<Project> findAll();
	

}
