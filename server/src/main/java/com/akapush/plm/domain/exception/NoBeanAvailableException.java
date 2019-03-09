package com.akapush.plm.domain.exception;

import com.akapush.plm.domain.enumartion.BeanType;

public class NoBeanAvailable extends Exception {

	private static final long serialVersionUID = 1L;

	public NoBeanAvailable(BeanType beanType, Long youngId) {
		super("No " + beanType.getValue() + " available with id : " + youngId);
	}

}
