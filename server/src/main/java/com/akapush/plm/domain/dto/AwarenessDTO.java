package com.akapush.plm.domain.dto;

import java.util.Date;
import java.util.List;

public class AwarenessDTO {

	private Long id;

	private String name;

	private Date date;

	private Long typeId;

	private Long publicTypeId;

	private Boolean signature;

	private Integer estimation;

	private String address1;

	private String address2;

	private String zipCode;

	private String city;

	private Long geographicFocusId;

	private String organiserStructure;

	private String contact;

	private String comment;

	private List<UserDTO> users;

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isSignature() {
		return signature;
	}

	public void setSignature(boolean signature) {
		this.signature = signature;
	}

	public Integer getEstimation() {
		return estimation;
	}

	public void setEstimation(Integer estimation) {
		this.estimation = estimation;
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

	public String getOrganiserStructure() {
		return organiserStructure;
	}

	public void setOrganiserStructure(String organiserStructure) {
		this.organiserStructure = organiserStructure;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public List<UserDTO> getUsers() {
		return users;
	}

	public void setUsers(List<UserDTO> users) {
		this.users = users;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public Long getPublicTypeId() {
		return publicTypeId;
	}

	public void setPublicTypeId(Long publicTypeId) {
		this.publicTypeId = publicTypeId;
	}

	public Boolean getSignature() {
		return signature;
	}

	public void setSignature(Boolean signature) {
		this.signature = signature;
	}

	public Long getGeographicFocusId() {
		return geographicFocusId;
	}

	public void setGeographicFocusId(Long geographicFocusId) {
		this.geographicFocusId = geographicFocusId;
	}

}
