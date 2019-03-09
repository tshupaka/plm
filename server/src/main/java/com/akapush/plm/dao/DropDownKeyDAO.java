package com.akapush.plm.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.akapush.plm.domain.model.DropDownKey;

@Repository
public interface DropDownKeyDAO extends CrudRepository<DropDownKey, Long> {

	DropDownKey findByKey(String key);

}
