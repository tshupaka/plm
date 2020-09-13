package com.akapush.plm.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.akapush.plm.domain.model.Young;

import java.util.List;

@Repository
public interface YoungDAO extends CrudRepository<Young, Long> {

	@Query("Select young from Young young order by young.lastname")
	Iterable<Young> getAllYWithCurrentAccompanying();

    List<Young> findByLastnameIgnoreCase(String lastname);
}
