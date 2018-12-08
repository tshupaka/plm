package com.akapush.plm.domain.exception;

public class NoYoungAvailable extends Exception {

	public NoYoungAvailable(Long youngId) {
		super("No Young available with id : " + youngId);
	}

}
