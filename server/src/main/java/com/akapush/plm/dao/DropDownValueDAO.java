package com.akapush.plm.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.akapush.plm.domain.model.DropDownValue;

@Repository
public interface DropDownValueDAO extends CrudRepository<DropDownValue, Long> {

}
