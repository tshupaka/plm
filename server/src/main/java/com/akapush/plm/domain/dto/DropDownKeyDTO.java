package com.akapush.plm.domain.dto;

import java.util.List;

public class DropDownKeyDTO {

	private String key;

	private List<DropDownValueDTO> values;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public List<DropDownValueDTO> getValues() {
		return values;
	}

	public void setValues(List<DropDownValueDTO> values) {
		this.values = values;
	}

}
