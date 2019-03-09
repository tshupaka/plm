package com.akapush.plm.dao;

import org.springframework.data.repository.CrudRepository;

import com.akapush.plm.domain.model.Awareness;
import com.akapush.plm.domain.model.Young;

public interface AwarenessDAO extends CrudRepository<Awareness, Long> {

	Iterable<Awareness> findByYoungs(Young young);
}
