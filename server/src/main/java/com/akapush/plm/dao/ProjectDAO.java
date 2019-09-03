package com.akapush.plm.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.akapush.plm.domain.model.Project;
import com.akapush.plm.domain.model.Young;

public interface ProjectDAO extends CrudRepository<Project, Long> {

	@Query("Select young from Young young " + "join  young.accompanyings accompanyings "
			+ " where  accompanyings.project.id = :id")
	Iterable<Young> findYoungsByProjectId(@Param("id") long id);

}
