package com.akapush.plm.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DROP_DOWN_VALUE")
public class DropDownValue {

	@Column(name = "DDV_ID")
	@Id
	private Long id;

	@Column(name = "DDV_VALUE")
	private String value;

	@Column(name = "DDV_ORDER")
	private Integer order;

	@JoinColumn(name = "DDK_ID")
	@ManyToOne(fetch = FetchType.LAZY)
	private DropDownKey dropDownKey;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public DropDownKey getDropDownKey() {
		return dropDownKey;
	}

	public void setDropDownKey(DropDownKey dropDownKey) {
		this.dropDownKey = dropDownKey;
	}

}
