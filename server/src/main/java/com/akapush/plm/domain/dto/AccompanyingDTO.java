package com.akapush.plm.domain.dto;

import java.util.Date;
import java.util.List;

public class AccompanyingDTO {

	private Long id;
	private Long foundingId;
	private Long accompanyingUserId;
	private Long type;
	private Date date;
	private Long mobilityTypeId;
	private Long projectId;
	private Long geographicZoneId;
	private String country;
	private Date departureDate;
	private Date returnDate;
	private Long durationId;
	private Date endAccompanyingDate;
	private Long endAccompanyingReasonId;
	private String endAccompanyingComment;
	private Date contactDate3Month;
	private Long position3MonthId;
	private String comment3Month;
	private Date contactDate6Month;
	private Long position6MonthId;
	private String comment6Month;
	private Boolean closed;
	private List<MeetingDTO> meetings;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFoundingId() {
		return foundingId;
	}

	public void setFoundingId(Long foundingId) {
		this.foundingId = foundingId;
	}

	public Long getAccompanyingUserId() {
		return accompanyingUserId;
	}

	public void setAccompanyingUserId(Long accompanyingUserId) {
		this.accompanyingUserId = accompanyingUserId;
	}

	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}

	public Boolean getClosed() {
		return closed;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getMobilityTypeId() {
		return mobilityTypeId;
	}

	public void setMobilityTypeId(Long mobilityTypeId) {
		this.mobilityTypeId = mobilityTypeId;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
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

	public void setDepartureDate(Date departure) {
		this.departureDate = departure;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date arrival) {
		this.returnDate = arrival;
	}

	public Long getDurationId() {
		return durationId;
	}

	public void setDurationId(Long duration) {
		this.durationId = duration;
	}

	public Date getEndAccompanyingDate() {
		return endAccompanyingDate;
	}

	public void setEndAccompanyingDate(Date endAccompanyingDate) {
		this.endAccompanyingDate = endAccompanyingDate;
	}

	public Long getEndAccompanyingReasonId() {
		return endAccompanyingReasonId;
	}

	public void setEndAccompanyingReasonId(Long endAccompanyingReasonId) {
		this.endAccompanyingReasonId = endAccompanyingReasonId;
	}

	public String getEndAccompanyingComment() {
		return endAccompanyingComment;
	}

	public void setEndAccompanyingComment(String endAccompanyingComment) {
		this.endAccompanyingComment = endAccompanyingComment;
	}

	public Date getContactDate3Month() {
		return contactDate3Month;
	}

	public void setContactDate3Month(Date contactDate3Month) {
		this.contactDate3Month = contactDate3Month;
	}

	public Long getPosition3MonthId() {
		return position3MonthId;
	}

	public void setPosition3MonthId(Long position3MonthId) {
		this.position3MonthId = position3MonthId;
	}

	public String getComment3Month() {
		return comment3Month;
	}

	public void setComment3Month(String comment3Month) {
		this.comment3Month = comment3Month;
	}

	public Date getContactDate6Month() {
		return contactDate6Month;
	}

	public void setContactDate6Month(Date contactDate6Month) {
		this.contactDate6Month = contactDate6Month;
	}

	public Long getPosition6MonthId() {
		return position6MonthId;
	}

	public void setPosition6MonthId(Long position6MonthId) {
		this.position6MonthId = position6MonthId;
	}

	public String getComment6Month() {
		return comment6Month;
	}

	public void setComment6Month(String comment6Month) {
		this.comment6Month = comment6Month;
	}

	public Boolean isClosed() {
		return closed;
	}

	public void setClosed(Boolean closed) {
		this.closed = closed;
	}

	public List<MeetingDTO> getMeetings() {
		return meetings;
	}

	public void setMeetings(List<MeetingDTO> meetings) {
		this.meetings = meetings;
	}

}
