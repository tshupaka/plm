package com.akapush.plm.service.internal;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akapush.plm.dao.ProjectDAO;
import com.akapush.plm.domain.enumartion.BeanType;
import com.akapush.plm.domain.exception.NoBeanAvailableException;
import com.akapush.plm.domain.model.Project;
import com.akapush.plm.domain.model.Young;
import com.akapush.plm.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectDAO projectDAO;

	@Override
	public Iterable<Project> getAllProjects() {

		return projectDAO.findAll();
	}

	@Override
	public Project getProjectById(long projectId) throws NoBeanAvailableException {
		Optional<Project> project = projectDAO.findById(projectId);
		if (project.isPresent()) {
			return project.get();
		}
		throw new NoBeanAvailableException(BeanType.PROJECT, projectId);
	}

	@Override
	public Project saveProject(Project project) {
		return projectDAO.save(project);
	}

	@Override
	public Iterable<Young> getYoungsByProjectId(long id) {
		return projectDAO.findYoungsByProjectId(id);
	}

}
