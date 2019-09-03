package com.akapush.plm.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.akapush.plm.domain.dto.ProjectDTO;
import com.akapush.plm.domain.dto.YoungDTO;
import com.akapush.plm.domain.exception.NoBeanAvailableException;
import com.akapush.plm.domain.model.Project;
import com.akapush.plm.domain.model.Young;
import com.akapush.plm.service.ProjectService;
import com.akapush.plm.util.ProjectHelper;
import com.akapush.plm.util.YoungHelper;

@RestController
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@Autowired
	private ProjectHelper projectHelper;

	@Autowired
	private YoungHelper youngHelper;

	@RequestMapping(value = "/api/project", method = RequestMethod.GET)
	public ResponseEntity<List<ProjectDTO>> getAllProjects() {
		Iterable<Project> projects = projectService.getAllProjects();
		List<ProjectDTO> projectsDTO = projectHelper.getProjectsDTO(projects);

		return new ResponseEntity<List<ProjectDTO>>(projectsDTO, HttpStatus.OK);

	}

	@RequestMapping(value = "/api/project/{projectId}", method = RequestMethod.GET)
	public ResponseEntity<ProjectDTO> getProjectById(@PathVariable("projectId") long id)
			throws NoBeanAvailableException {
		Project project = projectService.getProjectById(id);

		ProjectDTO projectDTO = projectHelper.getProjectDTO(project);

		return new ResponseEntity<ProjectDTO>(projectDTO, HttpStatus.OK);

	}

	@RequestMapping(value = "/api/project", method = RequestMethod.POST)
	public ResponseEntity<ProjectDTO> saveProject(@RequestBody ProjectDTO projectDTO) {
		Project project = projectHelper.getProject(projectDTO);
		project = projectService.saveProject(project);
		ProjectDTO saveProjectDTO = projectHelper.getProjectDTO(project);
		return new ResponseEntity<ProjectDTO>(saveProjectDTO, HttpStatus.OK);

	}

	@RequestMapping(value = "/api/project/{projectId}/young", method = RequestMethod.GET)
	public ResponseEntity<List<YoungDTO>> getAwarenessYoungs(@PathVariable("projectId") long id) {
		Iterable<Young> youngs = projectService.getYoungsByProjectId(id);
		List<YoungDTO> youngsDTO = youngHelper.getYoungsDTO(youngs);
		return new ResponseEntity<List<YoungDTO>>(youngsDTO, HttpStatus.OK);
	}

}
