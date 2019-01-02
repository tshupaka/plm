package com.akapush.plm.service;

import com.akapush.plm.domain.exception.InvalidBeanException;
import com.akapush.plm.domain.exception.NoBeanAvailable;
import com.akapush.plm.domain.model.Awareness;

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
	 * @throws NoBeanAvailable
	 */
	public Awareness getAwarenessById(Long id) throws NoBeanAvailable;

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
	public Iterable<Awareness> getAllAwareness();

}