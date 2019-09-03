package com.akapush.plm.domain.dto;

import java.util.Date;

public class YoungDTO {

	// Personal Data
	private Long id;
	private Long genderId;
	private String firstname;
	private String lastname;
	private Date birthday;
	private Boolean member;

	// Contact
	private String email;
	private String phone;
	private String facebook;
	private String skype;

	// Geographic situation
	private String address1;
	private String address2;
	private String zipCode;
	private String city;
	private Long geographicFocusId;
	private Long qpvStatusId;
	private Long qpvQuarterId;

	// Organisation contact
	private Long prescriberId;
	private String prescriberType;
	private String prescriberDetail;
	private String prescriberName;
	private String prescriberEmail;
	private String prescriberPhone;

	// Education
	private String educationLabel;
	private Long educationLevelId;
	private String lastCertificate;
	private Long englishLevelId;
	private String otherLanguage;

	// Professional status
	private Long employmentStatusId;
	private Date poleEmploiInscriptionDate;
	private Boolean rsaClaimant;
	private Boolean youngGuarantee;

	private Long accompanyingType;
	private Boolean sensitized;
	private Boolean accompanied;
	private UserDTO accompanyingUser;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGenderId() {
		return genderId;
	}

	public void setGenderId(Long genderId) {
		this.genderId = genderId;
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

	public Long getGeographicFocusId() {
		return geographicFocusId;
	}

	public void setGeographicFocusId(Long geographicFocusId) {
		this.geographicFocusId = geographicFocusId;
	}

	public Long getQpvStatusId() {
		return qpvStatusId;
	}

	public void setQpvStatusId(Long qpvStatusId) {
		this.qpvStatusId = qpvStatusId;
	}

	public Long getQpvQuarterId() {
		return qpvQuarterId;
	}

	public void setQpvQuarterId(Long qpvQuarterId) {
		this.qpvQuarterId = qpvQuarterId;
	}

	public Long getPrescriberId() {
		return prescriberId;
	}

	public void setPrescriberId(Long prescriberId) {
		this.prescriberId = prescriberId;
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

	public Long getEducationLevelId() {
		return educationLevelId;
	}

	public void setEducationLevelId(Long educationLevelId) {
		this.educationLevelId = educationLevelId;
	}

	public String getLastCertificate() {
		return lastCertificate;
	}

	public void setLastCertificate(String lastCertificate) {
		this.lastCertificate = lastCertificate;
	}

	public Long getEnglishLevelId() {
		return englishLevelId;
	}

	public void setEnglishLevelId(Long englishLevelId) {
		this.englishLevelId = englishLevelId;
	}

	public String getOtherLanguage() {
		return otherLanguage;
	}

	public void setOtherLanguage(String otherLanguage) {
		this.otherLanguage = otherLanguage;
	}

	public Long getEmploymentStatusId() {
		return employmentStatusId;
	}

	public void setEmploymentStatusId(Long employmentStatusId) {
		this.employmentStatusId = employmentStatusId;
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

	public String getPrescriberType() {
		return prescriberType;
	}

	public void setPrescriberType(String prescriberType) {
		this.prescriberType = prescriberType;
	}

	public Long getAccompanyingType() {
		return accompanyingType;
	}

	public void setAccompanyingType(Long accompanyingType) {
		this.accompanyingType = accompanyingType;
	}

	public Boolean getSensitized() {
		return sensitized;
	}

	public void setSensitized(Boolean sensitized) {
		this.sensitized = sensitized;
	}

	public Boolean getAccompanied() {
		return accompanied;
	}

	public void setAccompanied(Boolean accompanied) {
		this.accompanied = accompanied;
	}

	public UserDTO getAccompanyingUser() {
		return accompanyingUser;
	}

	public void setAccompanyingUser(UserDTO accompanyingUser) {
		this.accompanyingUser = accompanyingUser;
	}

}
