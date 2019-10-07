package com.akapush.plm.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "GROUP_")
public class Group {

	@Id
	@Column(name = "GRP_ID")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_plm_group_grp_id")
	@SequenceGenerator(name = "seq_plm_group_grp_id", sequenceName = "seq_plm_group_grp_id")
	private Long id;

	@Column(name = "GRP_NAME")
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
