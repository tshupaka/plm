package com.akapush.plm.domain.dto;

import java.util.List;

public class DropDownKeyDTO {

	private String key;

	private String label;

	private List<DropDownValueDTO> values;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<DropDownValueDTO> getValues() {
		return values;
	}

	public void setValues(List<DropDownValueDTO> values) {
		this.values = values;
	}

}
