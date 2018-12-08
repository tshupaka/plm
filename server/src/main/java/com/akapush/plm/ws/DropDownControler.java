package com.akapush.plm.ws;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akapush.plm.domain.dto.DropDownValueDTO;
import com.akapush.plm.domain.model.DropDownKey;
import com.akapush.plm.domain.model.DropDownValue;
import com.akapush.plm.service.DropDownService;
import com.akapush.plm.util.DropDownHelper;

@RestController
public class DropDownControler {

	@Autowired
	private DropDownService dropDownService;

	@RequestMapping("/api/dropdowns")
	public ResponseEntity<Map<String, List<DropDownValueDTO>>> getDropDowns(/* @AuthenticationPrincipal String userId */) {
		Map<DropDownKey, List<DropDownValue>> mapDropDownValues = dropDownService.getDropDownValues();
		Map<String, List<DropDownValueDTO>> dropDownValuesDTO = DropDownHelper.getDrowDownValuesDTO(mapDropDownValues);
		return new ResponseEntity<Map<String, List<DropDownValueDTO>>>(dropDownValuesDTO, HttpStatus.OK);
	}
}
