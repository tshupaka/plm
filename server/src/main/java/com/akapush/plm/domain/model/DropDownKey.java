package com.akapush.plm.domain.model;

import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "DROP_DOWN_KEY")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class DropDownKey {

	@Column(name = "DDK_ID")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_plm_drop_down_key_ddk_id")
	@SequenceGenerator(name = "seq_plm_drop_down_key_ddk_id", sequenceName = "seq_plm_drop_down_key_ddk_id")
	private Long id;

	@Column(name = "DDK_KEY")
	private String key;

	@Column(name = "DDK_LABEL")
	private String label;

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

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

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
		DropDownKey other = (DropDownKey) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
