package com.akapush.plm.service;

import com.akapush.plm.domain.exception.NoBeanAvailableException;
import com.akapush.plm.domain.model.Project;
import com.akapush.plm.domain.model.Young;

/**
 * This service provides methods to handle projects.
 *
 * @author eric
 *
 */
public interface ProjectService {

	/**
	 * Return all projects
	 * 
	 * @return
	 */
	Iterable<Project> getAllProjects();

	/**
	 * Return a project stored with the given id
	 * 
	 * @param id
	 * @return
	 */
	Project getProjectById(long id) throws NoBeanAvailableException;

	/**
	 * Save project and return project object with database id
	 * 
	 * @param project
	 * @return
	 */
	Project saveProject(Project project);

	/**
	 * Return youngs associated with a given project
	 * 
	 * @param id
	 * @return
	 */
	Iterable<Young> getYoungsByProjectId(long id);

}
