package com.akapush.plm.service;

import com.akapush.plm.domain.exception.AlreadyExistingYoungException;
import com.akapush.plm.domain.exception.InvalidBeanException;
import com.akapush.plm.domain.exception.NoBeanAvailableException;
import com.akapush.plm.domain.model.Accompanying;
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
	 * Delete a given young (and cascade all awarness & accompanying associated.
	 * 
	 * @param youngId
	 */
	void deleteYoungById(Long youngId) throws NoBeanAvailableException;

	/**
	 * Search young by firstname and lastname
	 * 
	 * @return
	 */
	Iterable<Young> getAllYoungs();

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

	/**
	 * 
	 * Get current (not closed) accompanying for a given young
	 * 
	 * @param youngId
	 * @return current accompanying
	 * @throws NoBeanAvailableException
	 */
	Accompanying getCurrentAccompanyingFromYoungId(long youngId) throws NoBeanAvailableException;

	/**
	 * Get historic (closed) accompanyings for a given young
	 * 
	 * @param youngId
	 * @return
	 */
	Iterable<Accompanying> getHistoricAccompanyings(long youngId);

	/**
	 * Return accompanying from its database id
	 * 
	 * @param accompanyingId
	 * @return
	 * @throws NoBeanAvailableException
	 */
	Accompanying getAccompanyingById(Long accompanyingId) throws NoBeanAvailableException;

	/**
	 * 
	 * Save the given accompanying
	 * 
	 * @param accompanying
	 * @return
	 */
	Accompanying saveAccompanying(Accompanying accompanying);

	/**
	 * Save young and return young with storage id.
	 *
	 * @param young
	 * @param forceInsert Force insert if young name is already registred
	 * @exception InvalidBeanException Occured when young hasn't name attribute defined
	 * @exception AlreadyExistingYoungException Occurend when young with same name is already registred
	 * @return
	 */
	Young saveYoung(Young young, boolean forceInsert) throws InvalidBeanException, AlreadyExistingYoungException;
}
