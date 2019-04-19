package com.akapush.plm.domain.dto;

import java.util.Date;

public class ProjectDTO {

	private Long id;
	private String name;
	private Long geographicZoneId;
	private String country;
	private Date departureDate;
	private Date returnDate;
	private Long durationId;

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

	public Long getGeographicZoneId() {
		return geographicZoneId;
	}

	public void setGeographicZoneId(Long geographicZoneId) {
		this.geographicZoneId = geographicZoneId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public Long getDurationId() {
		return durationId;
	}

	public void setDurationId(Long durationId) {
		this.durationId = durationId;
	}

}
