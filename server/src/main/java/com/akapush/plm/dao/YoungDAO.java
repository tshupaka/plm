package com.akapush.plm.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.akapush.plm.domain.model.Young;

@Repository
public interface YoungDAO extends CrudRepository<Young, Long> {

}
