package com.akapush.plm.service;

import com.akapush.plm.domain.exception.InvalidBeanException;
import com.akapush.plm.domain.exception.NoBeanAvailableException;
import com.akapush.plm.domain.model.Awareness;
import com.akapush.plm.domain.model.Young;

/**
 * This service provides method to handle Awareness.
 * 
 * @author eric
 *
 */
public interface AwarenessService {

	/**
	 * Return {@link Awareness} by id
	 * 
	 * @param id
	 * @return
	 * @throws NoBeanAvailableException
	 */
	public Awareness getAwarenessById(Long id) throws NoBeanAvailableException;

	/**
	 * Save {@link Awareness} and return storage id
	 * 
	 * @param awareness
	 * @return
	 * @throws InvalidBeanException
	 *             throwed if bean is invalid
	 */
	public Awareness saveAwareness(Awareness awareness) throws InvalidBeanException;

	/**
	 * Return All {@link Awareness}
	 * 
	 * @return
	 */
	public Iterable<Awareness> getAllAwarenesses();

	/**
	 * Return youngs associated with a given awareness
	 * 
	 * @param id
	 * @return
	 */
	public Iterable<Young> getAwarenessYoungs(long id);

}
