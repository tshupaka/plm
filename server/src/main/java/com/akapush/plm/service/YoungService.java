package com.akapush.plm.service;

import com.akapush.plm.domain.exception.InvalidBeanException;
import com.akapush.plm.domain.exception.NoBeanAvailable;
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
	 * @throws NoBeanAvailable
	 */
	Young getYoungById(Long youngId) throws NoBeanAvailable;

	/**
	 * Save young and return young with storage id.
	 * 
	 * @param young
	 * @exception Occured
	 *                when young hasn't name attribute defined
	 * @return
	 */
	Young saveYoung(Young young) throws InvalidBeanException;

}
