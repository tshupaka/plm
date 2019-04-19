package com.akapush.plm.domain.model;

import java.util.Date;

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
@Table(name = "PROJECT")
public class Project {

	@Id
	@Column(name = "PRO_ID")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_plm_project_pro_id")
	@SequenceGenerator(name = "seq_plm_project_pro_id", sequenceName = "seq_plm_project_pro_id")
	private Long id;

	@Column(name = "PRO_NAME")
	private String name;

	@JoinColumn(name = "GEOGRAPHIC_ZONE_DDV_ID")
	@ManyToOne(fetch = FetchType.EAGER)
	private DropDownValue geographicZone;

	@Column(name = "PRO_COUNTRY")
	private String country;

	@Column(name = "PRO_DEPARTURE")
	private Date departure;

	@Column(name = "PRO_ROUND_TRIP")
	private Date roundTrip;

	@JoinColumn(name = "DURATION_DDV_ID")
	@ManyToOne(fetch = FetchType.EAGER)
	private DropDownValue duration;

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

	public DropDownValue getGeographicZone() {
		return geographicZone;
	}

	public void setGeographicZone(DropDownValue geographicZone) {
		this.geographicZone = geographicZone;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getDeparture() {
		return departure;
	}

	public void setDeparture(Date departure) {
		this.departure = departure;
	}

	public Date getRoundTrip() {
		return roundTrip;
	}

	public void setRoundTrip(Date roundTrip) {
		this.roundTrip = roundTrip;
	}

	public DropDownValue getDuration() {
		return duration;
	}

	public void setDuration(DropDownValue duration) {
		this.duration = duration;
	}

}
