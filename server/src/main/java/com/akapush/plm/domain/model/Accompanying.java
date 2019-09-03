package com.akapush.plm.domain.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author eric
 *
 */
@Entity
@Table(name = "Accompanying")
public class Accompanying {

	@Id
	@Column(name = "ACC_ID")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_plm_accompanying_acc_id")
	@SequenceGenerator(name = "seq_plm_accompanying_acc_id", sequenceName = "seq_plm_accompanying_acc_id")
	private Long id;

	@JoinColumn(name = "FOUNDING_DDV_ID")
	@ManyToOne(fetch = FetchType.EAGER)
	private DropDownValue founding;

	@JoinColumn(name = "USR_ID_ACCOMPANYING")
	@ManyToOne(fetch = FetchType.EAGER)
	private User accompagnyingUser;

	@Column(name = "ACC_TYPE")
	private Long type;

	@Column(name = "ACC_DATE")
	private Date date;

	@JoinColumn(name = "MOBILITY_TYPE_DDV_ID")
	@ManyToOne(fetch = FetchType.EAGER)
	private DropDownValue mobilityType;

	@JoinColumn(name = "PRO_ID")
	@ManyToOne(fetch = FetchType.LAZY)
	private Project project;

	@JoinColumn(name = "GEOGRAPHIC_ZONE_DDV_ID")
	@ManyToOne(fetch = FetchType.EAGER)
	private DropDownValue geographicZone;

	@Column(name = "ACC_COUNTRY")
	private String country;

	@Column(name = "ACC_DEPARTURE_DATE")
	private Date departureDate;

	@Column(name = "ACC_RETURN_DATE")
	private Date returnDate;

	@JoinColumn(name = "DURATION_DDV_ID")
	@ManyToOne(fetch = FetchType.EAGER)
	private DropDownValue duration;

	@Column(name = "ACC_END_ACCOMPANYING_DATE")
	private Date endAccompanyingDate;

	@JoinColumn(name = "END_ACCOMPANYING_REASON_DDV_ID")
	@ManyToOne(fetch = FetchType.EAGER)
	private DropDownValue endAccompanyingReason;

	@Column(name = "ACC_END_ACCOMPANYING_COMMENT")
	private String endAccompanyingComment;

	@Column(name = "ACC_3MONTH_CONTACT_DATE")
	private Date contactDate3Month;

	@JoinColumn(name = "POSITION_3MONTH_DDV_ID")
	@ManyToOne(fetch = FetchType.EAGER)
	private DropDownValue position3Month;

	@Column(name = "ACC_3MONTH_COMMENT")
	private String comment3Month;

	@Column(name = "ACC_6MONTH_CONTACT_DATE")
	private Date contactDate6Month;

	@JoinColumn(name = "POSITION_6MONTH_DDV_ID")
	@ManyToOne(fetch = FetchType.EAGER)
	private DropDownValue position6Month;

	@Column(name = "ACC_6MONTH_COMMENT")
	private String comment6Month;

	@Column(name = "ACC_CLOSED")
	private Boolean closed;

	@OneToMany(mappedBy = "accompanying", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Meeting> meetings;

	@JoinColumn(name = "YOU_ID")
	@ManyToOne(fetch = FetchType.EAGER)
	private Young young;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DropDownValue getFounding() {
		return founding;
	}

	public void setFounding(DropDownValue founding) {
		this.founding = founding;
	}

	public User getAccompagnyingUser() {
		return accompagnyingUser;
	}

	public void setAccompagnyingUser(User accompagnyingUser) {
		this.accompagnyingUser = accompagnyingUser;
	}

	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public DropDownValue getMobilityType() {
		return mobilityType;
	}

	public void setMobilityType(DropDownValue mobilityType) {
		this.mobilityType = mobilityType;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
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

	public DropDownValue getDuration() {
		return duration;
	}

	public void setDuration(DropDownValue duration) {
		this.duration = duration;
	}

	public Date getEndAccompanyingDate() {
		return endAccompanyingDate;
	}

	public void setEndAccompanyingDate(Date endAccompanyingDate) {
		this.endAccompanyingDate = endAccompanyingDate;
	}

	public DropDownValue getEndAccompanyingReason() {
		return endAccompanyingReason;
	}

	public void setEndAccompanyingReason(DropDownValue endAccompanyingReason) {
		this.endAccompanyingReason = endAccompanyingReason;
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

	public DropDownValue getPosition3Month() {
		return position3Month;
	}

	public void setPosition3Month(DropDownValue position3Month) {
		this.position3Month = position3Month;
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

	public DropDownValue getPosition6Month() {
		return position6Month;
	}

	public void setPosition6Month(DropDownValue position6Month) {
		this.position6Month = position6Month;
	}

	public String getComment6Month() {
		return comment6Month;
	}

	public void setComment6Month(String comment6Month) {
		this.comment6Month = comment6Month;
	}

	public List<Meeting> getMeetings() {
		return meetings;
	}

	public void setMeetings(List<Meeting> meetings) {
		this.meetings = meetings;
	}

	public Young getYoung() {
		return young;
	}

	public void setYoung(Young young) {
		this.young = young;
	}

	public Boolean getClosed() {
		return closed;
	}

	public void setClosed(Boolean closed) {
		this.closed = closed;
	}

}
