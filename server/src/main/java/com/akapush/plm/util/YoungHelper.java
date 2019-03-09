package com.akapush.plm.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.akapush.plm.domain.dto.YoungDTO;
import com.akapush.plm.domain.model.DropDownValue;
import com.akapush.plm.domain.model.Young;

@Component
public class YoungHelper {

	public List<YoungDTO> getYoungsDTO(Iterable<Young> youngs) {
		List<YoungDTO> youngsDTO = new ArrayList<YoungDTO>();
		for (Young young : youngs) {
			YoungDTO youngDTO = getYoungDTO(young);
			youngsDTO.add(youngDTO);
		}
		return youngsDTO;
	}

	public YoungDTO getYoungDTO(Young young) {
		YoungDTO youngDTO = new YoungDTO();
		youngDTO.setAddress1(young.getAddress1());
		youngDTO.setAddress2(young.getAddress2());
		youngDTO.setBirthday(young.getBirthday());
		youngDTO.setCity(young.getCity());
		youngDTO.setEducationLabel(young.getEducationLabel());
		youngDTO.setEducationLevelId(getDropDownValueId(young.getEducationLevel()));
		youngDTO.setEmail(young.getEmail());
		youngDTO.setEmploymentStatusId(getDropDownValueId(young.getEmployementStatus()));
		youngDTO.setEnglishLevelId(getDropDownValueId(young.getEnglishLevel()));
		youngDTO.setFacebook(young.getFacebook());
		youngDTO.setFirstname(young.getFirstname());
		youngDTO.setGenderId(getDropDownValueId(young.getGender()));
		youngDTO.setGeographicFocusId(getDropDownValueId(young.getGeographicFocus()));
		youngDTO.setId(young.getId());
		youngDTO.setLastCertificate(young.getLastCertificate());
		youngDTO.setLastname(young.getLastname());
		youngDTO.setMember(young.getMember());
		youngDTO.setOtherLanguage(young.getOtherLanguage());
		youngDTO.setPhone(young.getPhone());
		youngDTO.setPoleEmploiInscriptionDate(young.getPoleEmploiInscriptionDate());
		youngDTO.setPrescriberDetail(young.getPrescriberDetail());
		youngDTO.setPrescriberEmail(young.getPrescriberEmail());
		youngDTO.setPrescriberId(getDropDownValueId(young.getPrescriber()));
		youngDTO.setPrescriberName(young.getPrescriberName());
		youngDTO.setPrescriberPhone(young.getPrescriberPhone());
		youngDTO.setPrescriberType(young.getPrescriberType());
		youngDTO.setQpvQuarterId(getDropDownValueId(young.getQpvQuarter()));
		youngDTO.setQpvStatusId(getDropDownValueId(young.getQpvStatus()));
		youngDTO.setRsaClaimant(young.getRsaClaimant());
		youngDTO.setSkype(young.getSkype());
		youngDTO.setYoungGuarantee(young.getYoungGuarantee());
		youngDTO.setZipCode(young.getZipCode());

		return youngDTO;
	}

	public Young getYoung(YoungDTO youngDTO) {
		Young young = new Young();
		young.setAddress1(youngDTO.getAddress1());
		young.setAddress2(youngDTO.getAddress2());
		young.setBirthday(youngDTO.getBirthday());
		young.setCity(youngDTO.getCity());
		young.setEducationLabel(youngDTO.getEducationLabel());
		young.setEducationLevel(createDropDownValue(youngDTO.getEducationLevelId()));
		young.setEmail(youngDTO.getEmail());
		young.setEmployementStatus(createDropDownValue(youngDTO.getEmploymentStatusId()));
		young.setEnglishLevel(createDropDownValue(youngDTO.getEnglishLevelId()));
		young.setFacebook(youngDTO.getFacebook());
		young.setFirstname(youngDTO.getFirstname());
		young.setGender(createDropDownValue(youngDTO.getGenderId()));
		young.setGeographicFocus(createDropDownValue(youngDTO.getGeographicFocusId()));
		young.setId(youngDTO.getId());
		young.setLastCertificate(youngDTO.getLastCertificate());
		young.setLastname(youngDTO.getLastname());
		young.setMember(youngDTO.getMember());
		young.setOtherLanguage(youngDTO.getOtherLanguage());
		young.setPhone(youngDTO.getPhone());
		young.setPoleEmploiInscriptionDate(youngDTO.getPoleEmploiInscriptionDate());
		young.setPrescriberDetail(youngDTO.getPrescriberDetail());
		young.setPrescriberEmail(youngDTO.getPrescriberEmail());
		young.setPrescriber(createDropDownValue(youngDTO.getPrescriberId()));
		young.setPrescriberName(youngDTO.getPrescriberName());
		young.setPrescriberPhone(youngDTO.getPrescriberPhone());
		young.setPrescriberType(youngDTO.getPrescriberType());
		young.setQpvQuarter(createDropDownValue(youngDTO.getQpvQuarterId()));
		young.setQpvStatus(createDropDownValue(youngDTO.getQpvStatusId()));
		young.setRsaClaimant(youngDTO.getRsaClaimant());
		young.setSkype(youngDTO.getSkype());
		young.setYoungGuarantee(youngDTO.getYoungGuarantee());
		young.setZipCode(youngDTO.getZipCode());

		return young;

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

	private Long getDropDownValueId(DropDownValue dropDownValue) {
		if (dropDownValue != null) {
			return dropDownValue.getId();
		}
		return null;
	}

}
