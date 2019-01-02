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
@Table(name = "USER_")
public class User {

	@Id
	@Column(name = "USR_ID")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_plm_user_usr_id")
	@SequenceGenerator(name = "seq_plm_user_usr_id", sequenceName = "seq_plm_user_usr_id")
	private Long id;

	@Column(name = "USR_FIRSTNAME")
	private String firstname;

	@Column(name = "USR_LASTNAME")
	private String lastname;

	@Column(name = "USR_LOGIN")
	private String login;

	@Column(name = "USR_PASSWORD")
	private String password;

	@JoinColumn(name = "GRP_ID")
	@ManyToOne(fetch = FetchType.LAZY)
	private Group group;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

}
