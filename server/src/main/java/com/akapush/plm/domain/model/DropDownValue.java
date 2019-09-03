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

	@Id
	@Column(name = "DDV_ID")
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DropDownValue other = (DropDownValue) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

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
