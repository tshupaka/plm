package com.akapush.plm.service;

import com.akapush.plm.domain.exception.NoYoungAvailable;
import com.akapush.plm.domain.model.Young;

/**
 * This service provide method to handle young bean
 */
public interface YoungService {

	/**
	 * Get young by Id
	 * 
	 * @param youngId
	 * @return
	 * @throws NoYoungAvailable
	 */
	Young getYoungById(Long youngId) throws NoYoungAvailable;

	/**
	 * Save young and return young with storage id.
	 * 
	 * @param young
	 * @return
	 */
	Young saveYoung(Young young);

}
