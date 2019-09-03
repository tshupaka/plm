package com.akapush.plm.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.akapush.plm.domain.dto.AccompanyingDTO;
import com.akapush.plm.domain.dto.MeetingDTO;
import com.akapush.plm.domain.model.Accompanying;
import com.akapush.plm.domain.model.DropDownValue;
import com.akapush.plm.domain.model.Meeting;
import com.akapush.plm.domain.model.Project;
import com.akapush.plm.domain.model.User;

@Component
public class AccompanyingHelper {

	@Autowired
	private UserHelper userHelper;

	public List<AccompanyingDTO> getAccompanyingDTOs(Iterable<Accompanying> accompanyings) {
		List<AccompanyingDTO> accompanyingDTOs = new ArrayList<>();
		for (Accompanying accompanying : accompanyings) {
			AccompanyingDTO accompanyingDTO = getAccompanyingDTO(accompanying);
			accompanyingDTOs.add(accompanyingDTO);
		}
		return accompanyingDTOs;
	}

	public AccompanyingDTO getAccompanyingDTO(Accompanying accompanying) {
		if (accompanying == null) {
			return null;
		}
		AccompanyingDTO accompanyingDTO = new AccompanyingDTO();
		accompanyingDTO.setReturnDate(accompanying.getReturnDate());
		accompanyingDTO.setComment3Month(accompanying.getComment3Month());
		accompanyingDTO.setComment6Month(accompanying.getComment6Month());
		accompanyingDTO.setContactDate3Month(accompanying.getContactDate3Month());
		accompanyingDTO.setContactDate6Month(accompanying.getContactDate6Month());
		accompanyingDTO.setCountry(accompanying.getCountry());
		accompanyingDTO.setDate(accompanying.getDate());
		accompanyingDTO.setDepartureDate(accompanying.getDepartureDate());
		accompanyingDTO.setDurationId(getDropDownValueId(accompanying.getDuration()));
		accompanyingDTO.setEndAccompanyingComment(accompanying.getEndAccompanyingComment());
		accompanyingDTO.setEndAccompanyingDate(accompanying.getEndAccompanyingDate());
		accompanyingDTO.setEndAccompanyingReasonId(getDropDownValueId(accompanying.getEndAccompanyingReason()));
		accompanyingDTO.setGeographicZoneId(getDropDownValueId(accompanying.getGeographicZone()));
		accompanyingDTO.setId(accompanying.getId());
		accompanyingDTO.setType(accompanying.getType());
		accompanyingDTO.setMeetings(getMeetingsDTO(accompanying.getMeetings()));
		accompanyingDTO.setMobilityTypeId(getDropDownValueId(accompanying.getMobilityType()));
		accompanyingDTO.setPosition3MonthId(getDropDownValueId(accompanying.getPosition3Month()));
		accompanyingDTO.setPosition6MonthId(getDropDownValueId(accompanying.getPosition6Month()));
		accompanyingDTO.setProjectId(getProjectId(accompanying.getProject()));
		accompanyingDTO.setAccompanyingUserId(getUserId(accompanying.getAccompagnyingUser()));
		accompanyingDTO.setFoundingId(getDropDownValueId(accompanying.getFounding()));
		accompanyingDTO.setClosed(accompanying.getClosed());

		return accompanyingDTO;
	}

	public Accompanying getAccompanying(AccompanyingDTO accompanyingDTO) {
		if (accompanyingDTO == null) {
			return null;
		}
		Accompanying accompanying = new Accompanying();
		accompanying.setReturnDate(accompanyingDTO.getReturnDate());
		accompanying.setComment3Month(accompanyingDTO.getComment3Month());
		accompanying.setComment6Month(accompanyingDTO.getComment6Month());
		accompanying.setContactDate3Month(accompanyingDTO.getContactDate3Month());
		accompanying.setContactDate6Month(accompanyingDTO.getContactDate6Month());
		accompanying.setCountry(accompanyingDTO.getCountry());
		accompanying.setDate(accompanyingDTO.getDate());
		accompanying.setDepartureDate(accompanyingDTO.getDepartureDate());
		accompanying.setDuration(createDropDownValue(accompanyingDTO.getDurationId()));
		accompanying.setEndAccompanyingComment(accompanyingDTO.getEndAccompanyingComment());
		accompanying.setEndAccompanyingDate(accompanyingDTO.getEndAccompanyingDate());
		accompanying.setEndAccompanyingReason(createDropDownValue(accompanyingDTO.getEndAccompanyingReasonId()));
		accompanying.setGeographicZone(createDropDownValue(accompanyingDTO.getGeographicZoneId()));
		accompanying.setId(accompanyingDTO.getId());
		accompanying.setType(accompanyingDTO.getType());
		accompanying.setMeetings(getMeetings(accompanyingDTO.getMeetings(), accompanying));
		accompanying.setMobilityType(createDropDownValue(accompanyingDTO.getMobilityTypeId()));
		accompanying.setPosition3Month(createDropDownValue(accompanyingDTO.getPosition3MonthId()));
		accompanying.setPosition6Month(createDropDownValue(accompanyingDTO.getPosition6MonthId()));
		accompanying.setProject(getProject(accompanyingDTO.getProjectId()));
		accompanying.setClosed(accompanyingDTO.isClosed());
		accompanying.setFounding(createDropDownValue(accompanyingDTO.getFoundingId()));
		accompanying.setAccompagnyingUser(getUser(accompanyingDTO.getAccompanyingUserId()));
		return accompanying;
	}

	private Project getProject(Long projectId) {
		if (projectId == null) {
			return null;
		}
		Project project = new Project();
		project.setId(projectId);
		return project;
	}

	private User getUser(Long userId) {
		if (userId == null) {
			return null;
		}
		User user = new User();
		user.setId(userId);
		return user;
	}

	private List<Meeting> getMeetings(List<MeetingDTO> meetingsDTO, Accompanying accompanying) {
		if (meetingsDTO == null) {
			return null;
		}
		List<Meeting> meetings = new ArrayList<>();
		for (MeetingDTO meetingDTO : meetingsDTO) {
			Meeting meeting = getMeeting(meetingDTO, accompanying);
			meetings.add(meeting);
		}
		return meetings;
	}

	private Meeting getMeeting(MeetingDTO meetingDTO, Accompanying accompanying) {
		Meeting meeting = new Meeting();
		meeting.setComment(meetingDTO.getComment());
		meeting.setDate(meetingDTO.getDate());
		meeting.setDescription(meetingDTO.getDescription());
		meeting.setId(meetingDTO.getId());
		meeting.setAccompanying(accompanying);
		meeting.setUser(userHelper.getUser(meetingDTO.getUser()));
		return meeting;
	}

	private Long getProjectId(Project project) {
		if (project == null) {
			return null;
		} else {
			return project.getId();
		}
	}

	private Long getUserId(User accompagnyingUser) {
		if (accompagnyingUser == null) {
			return null;
		} else {
			return accompagnyingUser.getId();
		}
	}

	private List<MeetingDTO> getMeetingsDTO(List<Meeting> meetings) {
		if (meetings == null) {
			return null;
		} else {
			List<MeetingDTO> meetingDTOs = new ArrayList<>();
			for (Meeting meeting : meetings) {
				MeetingDTO meetingDTO = getMeetingDTO(meeting);
				meetingDTOs.add(meetingDTO);
			}
			return meetingDTOs;
		}
	}

	private MeetingDTO getMeetingDTO(Meeting meeting) {
		if (meeting == null) {
			return null;
		} else {
			MeetingDTO meetingDTO = new MeetingDTO();
			meetingDTO.setComment(meeting.getComment());
			meetingDTO.setDate(meeting.getDate());
			meetingDTO.setDescription(meeting.getDescription());
			meetingDTO.setId(meeting.getId());
			meetingDTO.setUser(userHelper.getUserDTO(meeting.getUser()));
			return meetingDTO;
		}

	}

	private Long getDropDownValueId(DropDownValue dropDownValue) {
		if (dropDownValue != null) {
			return dropDownValue.getId();
		}
		return null;
	}

	private DropDownValue createDropDownValue(Long id) {
		if (id == null) {
			return null;
		} else {
			DropDownValue dropDownValue = new DropDownValue();
			dropDownValue.setId(id);
			return dropDownValue;
		}
	}

}
