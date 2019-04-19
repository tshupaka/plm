package com.akapush.plm.domain.enumartion;

public enum BeanType {

	YOUNG("young"), AWARENESS("awareness"), USER("user"), DROPDOWN_KEY("dropDownKey"), PROJECT("project");

	private String value;

	private BeanType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
