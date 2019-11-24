package com.akapush.plm.service;

import com.akapush.plm.domain.exception.NoBeanAvailableException;
import com.akapush.plm.domain.model.DropDownKey;
import com.akapush.plm.domain.model.DropDownValue;

/**
 * This service provide methods to handle dropdowns.
 * 
 * @author eric
 *
 */
public interface DropDownService {

	/**
	 * Return all dropdown values sorted by key
	 * 
	 * @return
	 */
	Iterable<DropDownKey> getDropDownValues();

	/**
	 * Add new value to a given dropdown key
	 * 
	 * @param key
	 * @param value
	 * @param order
	 * @return
	 * @throws NoBeanAvailableException
	 */
	DropDownValue addNewValue(String key, String value, Integer order) throws NoBeanAvailableException;

	/**
	 * Remove a dropdownvalue identified by id from database
	 * 
	 * @param dropdownValueId
	 */
	void removeDropDownValue(Long dropdownValueId);
}
