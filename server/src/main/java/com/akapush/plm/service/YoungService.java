package com.akapush.plm.service;

import com.akapush.plm.domain.exception.InvalidBeanException;
import com.akapush.plm.domain.exception.NoBeanAvailableException;
import com.akapush.plm.domain.model.Awareness;
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
	 * @throws NoBeanAvailableException
	 */
	Young getYoungById(Long youngId) throws NoBeanAvailableException;

	/**
	 * Save young and return young with storage id.
	 * 
	 * @param young
	 * @exception Occured
	 *                when young hasn't name attribute defined
	 * @return
	 */
	Young saveYoung(Young young) throws InvalidBeanException;

	/**
	 * Search young by firstname and lastname
	 * 
	 * @param search
	 * @return
	 */
	Iterable<Young> searchYoungs(String search);

	/**
	 * Get awarnesses of a given young
	 * 
	 * @param youngId
	 * @return
	 */
	Iterable<Awareness> getAwarenessesFromYoungId(long youngId);

	/**
	 * Associate a awareness to a given young
	 * 
	 * @param youngId
	 * @param awarenessId
	 * @return the awareness corresponding to awarenessId
	 * @throws NoBeanAvailableException
	 */
	Awareness addAwarenessToYoung(Long youngId, Long awarenessId) throws NoBeanAvailableException;

	/**
	 * Remove awareness from given young
	 * 
	 * @param youngId
	 * @param awarenessId
	 * @return list of awarenesses available for young
	 * @throws NoBeanAvailableException
	 */
	Iterable<Awareness> deleteAwarenessFromYoung(long youngId, long awarenessId) throws NoBeanAvailableException;

}
