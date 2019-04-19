package com.akapush.plm.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.akapush.plm.domain.enumartion.BeanType;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NoBeanAvailableException extends Exception {

	private static final long serialVersionUID = 1L;

	public NoBeanAvailableException(BeanType beanType, Long youngId) {
		super("No " + beanType.getValue() + " available with id : " + youngId);
	}

	public NoBeanAvailableException(BeanType beanType, String key) {
		super("No " + beanType.getValue() + " available with key : " + key);
	}

}
