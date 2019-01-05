package com.akapush.plm.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.akapush.plm.domain.model.Young;

@Repository
public interface YoungDAO extends CrudRepository<Young, Long> {

	@Query("Select young from Young young where upper(young.lastname) like %:search% or upper(young.firstname) like %:search%")
	Iterable<Young> searchYoung(@Param("search") String search);

}
