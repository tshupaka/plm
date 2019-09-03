package com.akapush.plm.service;

import com.akapush.plm.domain.exception.NoBeanAvailableException;
import com.akapush.plm.domain.model.Project;
import com.akapush.plm.domain.model.Young;

public interface ProjectService {

	/**
	 * Return all projects
	 * 
	 * @return
	 */
	public Iterable<Project> getAllProjects();

	/**
	 * Return a project stored with the given id
	 * 
	 * @param id
	 * @return
	 */
	public Project getProjectById(long id) throws NoBeanAvailableException;

	/**
	 * Save project and return project object with database id
	 * 
	 * @param project
	 * @return
	 */
	public Project saveProject(Project project);

	/**
	 * Return youngs associated with a given project
	 * 
	 * @param id
	 * @return
	 */
	public Iterable<Young> getYoungsByProjectId(long id);

}
