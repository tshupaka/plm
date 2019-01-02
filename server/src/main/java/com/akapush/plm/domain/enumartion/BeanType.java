package com.akapush.plm.domain.enumartion;

public enum BeanType {

	YOUNG("young"), AWARENESS("awareness"), USER("user");

	private String value;

	private BeanType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}