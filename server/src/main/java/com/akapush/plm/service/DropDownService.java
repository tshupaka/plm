package com.akapush.plm.service;

import java.util.List;
import java.util.Map;

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
	public Map<DropDownKey, List<DropDownValue>> getDropDownValues();
}
