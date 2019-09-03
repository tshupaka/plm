package com.akapush.plm.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.akapush.plm.domain.dto.ProjectDTO;
import com.akapush.plm.domain.model.DropDownValue;
import com.akapush.plm.domain.model.Project;

@Component
public class ProjectHelper {

	public List<ProjectDTO> getProjectsDTO(Iterable<Project> projects) {
		List<ProjectDTO> projectsDTO = new ArrayList<ProjectDTO>();
		for (Project project : projects) {
			ProjectDTO projectDTO = getProjectDTO(project);
			projectsDTO.add(projectDTO);
		}
		return projectsDTO;
	}

	public ProjectDTO getProjectDTO(Project project) {
		ProjectDTO projectDTO = new ProjectDTO();
		projectDTO.setId(project.getId());
		projectDTO.setName(project.getName());
		projectDTO.setDepartureDate(project.getDeparture());
		projectDTO.setReturnDate(project.getRoundTrip());
		projectDTO.setDurationId(getDropDownValueId(project.getDuration()));
		projectDTO.setGeographicZoneId(getDropDownValueId(project.getGeographicZone()));
		projectDTO.setCountry(project.getCountry());
		return projectDTO;
	}

	public Project getProject(ProjectDTO projectDTO) {
		if (projectDTO == null) {
			return null;
		}
		Project project = new Project();
		project.setId(projectDTO.getId());
		project.setName(projectDTO.getName());
		project.setDeparture(projectDTO.getDepartureDate());
		project.setRoundTrip(projectDTO.getReturnDate());
		project.setDuration(createDropDownValue(projectDTO.getDurationId()));
		project.setGeographicZone(createDropDownValue(projectDTO.getGeographicZoneId()));
		project.setCountry(projectDTO.getCountry());
		return project;

	}

	private Long getDropDownValueId(DropDownValue dropDownValue) {
		if (dropDownValue != null) {
			return dropDownValue.getId();
		}
		return null;
	}

	private DropDownValue createDropDownValue(Long id) {
		if (id == null) {
			return null;
		} else {
			DropDownValue dropDownValue = new DropDownValue();
			dropDownValue.setId(id);
			return dropDownValue;
		}
	}

}
