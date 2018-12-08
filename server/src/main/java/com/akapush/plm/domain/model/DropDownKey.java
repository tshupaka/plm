package com.akapush.plm.domain.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "DROP_DOWN_KEY")
public class DropDownKey {

	@Column(name = "DDK_ID")
	@Id
	private Long id;

	@Column(name = "DDK_KEY")
	private String key;

	@OneToMany(mappedBy = "dropDownKey")
	private List<DropDownValue> dropDownValues;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public List<DropDownValue> getDropDownValues() {
		return dropDownValues;
	}

	public void setDropDownValues(List<DropDownValue> dropDownValues) {
		this.dropDownValues = dropDownValues;
	}

}
