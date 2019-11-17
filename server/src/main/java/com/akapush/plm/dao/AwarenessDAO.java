package com.akapush.plm.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.akapush.plm.domain.model.Awareness;
import com.akapush.plm.domain.model.Young;

public interface AwarenessDAO extends CrudRepository<Awareness, Long> {

	Iterable<Awareness> findByYoungs(Young young);

	@Query("Select young from Young young " + "join young.awarenesses awarenesses "
			+ "left join  young.accompanyings accompanyings on accompanyings.closed = false"
			+ " where awarenesses.id = :id")
	Iterable<Young> findYoungByAwareness(@Param("id") long id);

	Iterable<Awareness> findByOrderByDateDesc();
}
