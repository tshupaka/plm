package com.akapush.plm.domain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "YOUNG")
public class Young {

	// Personal Data
	@Column(name = "YOU_ID")
	@Id
	private Long id;
	@JoinColumn(name = "GENDER_DDV_ID")
	@ManyToOne(fetch = FetchType.EAGER)
	private DropDownValue gender;
	@Column(name = "YOU_FIRSTNAME")
	private String firstname;
	@Column(name = "YOU_LASTNAME")
	private String lastname;
	@Column(name = "YOU_BIRTHDAY")
	private Date birthday;
	@Column(name = "YOU_MEMBER")
	private Boolean member;

	// Contact
	@Column(name = "YOU_EMAIL")
	private String email;
	@Column(name = "YOU_PHONE")
	private String phone;
	@Column(name = "YOU_FACEBOOK")
	private String facebook;
	@Column(name = "YOU_SKYPE")
	private String skype;

	// Geographic situation
	@Column(name = "YOU_ADDRESS1")
	private String address1;
	@Column(name = "YOU_ADDRESS2")
	private String address2;
	@Column(name = "YOU_ZIPCODE")
	private String zipCode;
	@Column(name = "YOU_CITY")
	private String city;
	@JoinColumn(name = "GEOGRAPHIC_FOCUS_DDV_ID")
	@ManyToOne(fetch = FetchType.EAGER)
	private DropDownValue geographicFocus;
	@JoinColumn(name = "QPV_STATUS_DDV_ID")
	@ManyToOne(fetch = FetchType.EAGER)
	private DropDownValue qpvStatus;
	@JoinColumn(name = "QPV_QUARTER_DDV_ID")
	@ManyToOne(fetch = FetchType.EAGER)
	private DropDownValue qpvQuarter;

	// Organisation contact
	@JoinColumn(name = "PRESCRIBER_DDV_ID")
	@ManyToOne(fetch = FetchType.EAGER)
	private DropDownValue prescriber;

	@Column(name = "PRESCRIBER_TYPE_DDV_ID")
	private DropDownValue prescriberType;

	@Column(name = "YOU_PRESCRIBER_DETAIL")
	private String prescriberDetail;

	@Column(name = "YOU_PRESCRIBER_NAME")
	private String prescriberName;

	@Column(name = "YOU_PRESCRIBER_EMAIL")
	private String prescriberEmail;

	@Column(name = "YOU_PRESCRIBER_PHONE")
	private String prescriberPhone;

	// Education

	@Column(name = "YOU_EDUCATION_LABEL")
	private String educationLabel;
	@JoinColumn(name = "EDUCATION_LEVEL_DDV_ID")
	@ManyToOne(fetch = FetchType.EAGER)
	private DropDownValue educationLevel;

	@Column(name = "YOU_LAST_CERTIFICATE")
	private String lastCertificate;

	@JoinColumn(name = "ENGLISH_LEVEL_DDV_ID")
	@ManyToOne(fetch = FetchType.EAGER)
	private DropDownValue englishLevel;

	@Column(name = "YOU_OTHER_LANGUAGE")
	private String otherLanguage;

	// Professional status
	@JoinColumn(name = "EMPLOYEMENT_STATUS_DDV_ID")
	@ManyToOne(fetch = FetchType.EAGER)
	private DropDownValue employementStatus;

	@Column(name = "YOU_POLE_EMPLOI_INSCRIPTION_DATE")
	private Date poleEmploiInscriptionDate;

	@Column(name = "YOU_RSA_CLAIMANT")
	private Boolean rsaClaimant;

	@Column(name = "YOU_YOUNG_GUARANTEE")
	private Boolean youngGuarantee;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DropDownValue getGender() {
		return gender;
	}

	public void setGender(DropDownValue gender) {
		this.gender = gender;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Boolean getMember() {
		return member;
	}

	public void setMember(Boolean member) {
		this.member = member;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getSkype() {
		return skype;
	}

	public void setSkype(String skype) {
		this.skype = skype;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public DropDownValue getGeographicFocus() {
		return geographicFocus;
	}

	public void setGeographicFocus(DropDownValue geographicFocus) {
		this.geographicFocus = geographicFocus;
	}

	public DropDownValue getQpvStatus() {
		return qpvStatus;
	}

	public void setQpvStatus(DropDownValue qpvStatus) {
		this.qpvStatus = qpvStatus;
	}

	public DropDownValue getQpvQuarter() {
		return qpvQuarter;
	}

	public void setQpvQuarter(DropDownValue qpvQuarter) {
		this.qpvQuarter = qpvQuarter;
	}

	public DropDownValue getPrescriber() {
		return prescriber;
	}

	public void setPrescriber(DropDownValue prescriber) {
		this.prescriber = prescriber;
	}

	public DropDownValue getPrescriberType() {
		return prescriberType;
	}

	public void setPrescriberType(DropDownValue prescriberType) {
		this.prescriberType = prescriberType;
	}

	public String getPrescriberDetail() {
		return prescriberDetail;
	}

	public void setPrescriberDetail(String prescriberDetail) {
		this.prescriberDetail = prescriberDetail;
	}

	public String getPrescriberName() {
		return prescriberName;
	}

	public void setPrescriberName(String prescriberName) {
		this.prescriberName = prescriberName;
	}

	public String getPrescriberEmail() {
		return prescriberEmail;
	}

	public void setPrescriberEmail(String prescriberEmail) {
		this.prescriberEmail = prescriberEmail;
	}

	public String getPrescriberPhone() {
		return prescriberPhone;
	}

	public void setPrescriberPhone(String prescriberPhone) {
		this.prescriberPhone = prescriberPhone;
	}

	public String getEducationLabel() {
		return educationLabel;
	}

	public void setEducationLabel(String educationLabel) {
		this.educationLabel = educationLabel;
	}

	public DropDownValue getEducationLevel() {
		return educationLevel;
	}

	public void setEducationLevel(DropDownValue educationLevel) {
		this.educationLevel = educationLevel;
	}

	public String getLastCertificate() {
		return lastCertificate;
	}

	public void setLastCertificate(String lastCertificate) {
		this.lastCertificate = lastCertificate;
	}

	public DropDownValue getEnglishLevel() {
		return englishLevel;
	}

	public void setEnglishLevel(DropDownValue englishLevel) {
		this.englishLevel = englishLevel;
	}

	public String getOtherLanguage() {
		return otherLanguage;
	}

	public void setOtherLanguage(String otherLanguage) {
		this.otherLanguage = otherLanguage;
	}

	public DropDownValue getEmployementStatus() {
		return employementStatus;
	}

	public void setEmployementStatus(DropDownValue employementStatus) {
		this.employementStatus = employementStatus;
	}

	public Date getPoleEmploiInscriptionDate() {
		return poleEmploiInscriptionDate;
	}

	public void setPoleEmploiInscriptionDate(Date poleEmploiInscriptionDate) {
		this.poleEmploiInscriptionDate = poleEmploiInscriptionDate;
	}

	public Boolean getRsaClaimant() {
		return rsaClaimant;
	}

	public void setRsaClaimant(Boolean rsaClaimant) {
		this.rsaClaimant = rsaClaimant;
	}

	public Boolean getYoungGuarantee() {
		return youngGuarantee;
	}

	public void setYoungGuarantee(Boolean youngGuarantee) {
		this.youngGuarantee = youngGuarantee;
	}

}