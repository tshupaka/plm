package com.akapush.plm.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.akapush.plm.domain.dto.AwarenessDTO;
import com.akapush.plm.domain.dto.UserDTO;
import com.akapush.plm.domain.model.Awareness;
import com.akapush.plm.domain.model.DropDownValue;
import com.akapush.plm.domain.model.User;

/**
 * This classe provide helper to convert {@link Awareness} bean to
 * {@link AwarenessDTO}.
 * 
 * @author eric
 *
 */
@Component
public class AwarenessHelper {

	@Autowired
	private UserHelper userHelper;

	public AwarenessDTO getAwarenessDTO(Awareness awareness) {
		AwarenessDTO awarenessDTO = new AwarenessDTO();
		awarenessDTO.setAddress1(awareness.getAddress1());
		awarenessDTO.setAddress2(awareness.getAddress2());
		awarenessDTO.setCity(awareness.getCity());
		awarenessDTO.setComment(awareness.getComment());
		awarenessDTO.setContact(awareness.getContact());
		awarenessDTO.setDate(awareness.getDate());
		awarenessDTO.setEstimation(awareness.getEstimation());
		awarenessDTO.setGeographicFocusId(getDropDownValueId(awareness.getGeographicFocus()));
		awarenessDTO.setId(awareness.getId());
		awarenessDTO.setName(awareness.getName());
		awarenessDTO.setOrganiserStructure(awareness.getOrganiserStructure());
		awarenessDTO.setPublicTypeId(getDropDownValueId(awareness.getPublicType()));
		awarenessDTO.setSignature(awareness.getSignature());
		awarenessDTO.setTypeId(getDropDownValueId(awareness.getType()));
		awarenessDTO.setUsers(getUsersDTO(awareness.getUsers()));
		awarenessDTO.setZipCode(awareness.getZipCode());

		return awarenessDTO;
	}

	public Awareness getAwareness(AwarenessDTO awarenessDTO) {
		Awareness awareness = new Awareness();
		awareness.setAddress1(awarenessDTO.getAddress1());
		awareness.setAddress2(awarenessDTO.getAddress2());
		awareness.setCity(awarenessDTO.getCity());
		awareness.setComment(awarenessDTO.getComment());
		awareness.setContact(awarenessDTO.getContact());
		awareness.setDate(awarenessDTO.getDate());
		awareness.setEstimation(awarenessDTO.getEstimation());
		awareness.setGeographicFocus(createDropDownValue(awarenessDTO.getGeographicFocusId()));
		awareness.setId(awarenessDTO.getId());
		awareness.setName(awarenessDTO.getName());
		awareness.setOrganiserStructure(awarenessDTO.getOrganiserStructure());
		awareness.setPublicType(createDropDownValue(awarenessDTO.getPublicTypeId()));
		awareness.setSignature(awarenessDTO.getSignature());
		awareness.setType(createDropDownValue(awarenessDTO.getTypeId()));
		awareness.setUsers(getUsers(awarenessDTO.getUsers()));
		awareness.setZipCode(awarenessDTO.getZipCode());

		return awareness;
	}

	public List<AwarenessDTO> getAwarenessDTO(Iterable<Awareness> awarenesses) {
		List<AwarenessDTO> awarenessesDTO = new ArrayList<>();
		for (Awareness awareness : awarenesses) {
			awarenessesDTO.add(getAwarenessDTO(awareness));
		}
		return awarenessesDTO;
	}

	private List<User> getUsers(List<UserDTO> usersDTO) {
		if (usersDTO == null) {
			return null;
		}
		List<User> users = new ArrayList<>(usersDTO.size());
		for (UserDTO userDTO : usersDTO) {
			User user = userHelper.getUser(userDTO);
			users.add(user);
		}
		return users;
	}

	private List<UserDTO> getUsersDTO(List<User> users) {
		if (users == null) {
			return null;
		}
		List<UserDTO> usersDTO = new ArrayList<>(users.size());
		for (User user : users) {
			UserDTO userDTO = userHelper.getUserDTO(user);
			usersDTO.add(userDTO);
		}
		return usersDTO;
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
