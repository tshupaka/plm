package com.akapush.plm.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "DROP_DOWN_VALUE")
public class DropDownValue {

	@Column(name = "DDV_ID")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_plm_drop_down_value_ddv_id")
	@SequenceGenerator(name = "seq_plm_drop_down_value_ddv_id", sequenceName = "seq_plm_drop_down_value_ddv_id")
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
