package com.akapush.plm.dao;

import org.springframework.data.repository.CrudRepository;

import com.akapush.plm.domain.model.Project;

public interface ProjectDAO extends CrudRepository<Project, Long> {

}
