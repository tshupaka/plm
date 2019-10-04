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
@Table
public class Meeting implements Comparable<Meeting> {

	@Id
	@Column(name = "MEE_ID")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_plm_meeting_mee_id")
	@SequenceGenerator(name = "seq_plm_meeting_mee_id", sequenceName = "seq_plm_meeting_mee_id")
	private Long id;
	@Column(name = "MEE_DATE")
	private Date date;
	@Column(name = "MEE_DESCRIPTION")
	private String description;
	@Column(name = "MEE_COMMENT")
	private String comment;

	@JoinColumn(name = "USR_ID")
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

	@JoinColumn(name = "ACC_ID")
	@ManyToOne(fetch = FetchType.LAZY)
	private Accompanying accompanying;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Accompanying getAccompanying() {
		return accompanying;
	}

	public void setAccompanying(Accompanying accompanying) {
		this.accompanying = accompanying;
	}

	@Override
	public int compareTo(Meeting meeting) {
		if (meeting == null) {
			return 1;
		}
		if (this.date == null && meeting.date == null) {
			return 0;
		}
		if (this.date == null && meeting.date != null) {
			return -1;
		}
		if (this.date != null && meeting.date == null) {
			return 1;
		}

		return this.date.compareTo(meeting.date);
	}

}
