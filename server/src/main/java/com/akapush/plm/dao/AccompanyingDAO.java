package com.akapush.plm.dao;

import org.springframework.data.repository.CrudRepository;

import com.akapush.plm.domain.model.Accompanying;
import com.akapush.plm.domain.model.Young;

public interface AccompanyingDAO extends CrudRepository<Accompanying, Long> {

	Iterable<Accompanying> findAccompanyingByYoungAndClosed(Young young, Boolean closed);

}
