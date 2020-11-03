package com.akapush.plm.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.akapush.plm.domain.model.Young;

import java.util.List;

@Repository
public interface YoungDAO extends CrudRepository<Young, Long> {

	@Query("Select distinct young from Young young left join fetch young.accompanyings ")
	Iterable<Young> getAllYoungsYWithCurrentAccompanying();

    List<Young> findByLastnameIgnoreCase(String lastname);

    @Query("Select distinct young from Young young left join fetch young.awarenesses")
    Iterable<Young> getAllYoungsWithAwareness();
}
