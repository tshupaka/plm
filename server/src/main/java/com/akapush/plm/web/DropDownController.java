package com.akapush.plm.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.akapush.plm.domain.dto.DropDownKeyDTO;
import com.akapush.plm.domain.dto.DropDownValueDTO;
import com.akapush.plm.domain.exception.NoBeanAvailableException;
import com.akapush.plm.domain.model.DropDownKey;
import com.akapush.plm.domain.model.DropDownValue;
import com.akapush.plm.service.DropDownService;
import com.akapush.plm.util.DropDownHelper;

@RestController
public class DropDownController {

	@Autowired
	private DropDownService dropDownService;

	@RequestMapping("/api/dropdowns")
	public ResponseEntity<List<DropDownKeyDTO>> getDropDowns(/*
																 * @AuthenticationPrincipal String userId
																 */) {
		Iterable<DropDownKey> dropDownKeys = dropDownService.getDropDownValues();
		List<DropDownKeyDTO> dropDownkeysDTO = DropDownHelper.getDrowDownKeyDTO(dropDownKeys);
		return new ResponseEntity<List<DropDownKeyDTO>>(dropDownkeysDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/api/dropdowns", method = RequestMethod.POST)
	public ResponseEntity<DropDownValueDTO> addDropdownValue(@RequestBody Map<String, String> parameters) {
		try {
			// TODO vérifier l'existence des paramètres
			String key = parameters.get("key");
			String value = parameters.get("value");
			Integer order = Integer.parseInt(parameters.get("order"));
			DropDownValue dropDownValue = dropDownService.addNewValue(key, value, order);
			DropDownValueDTO dropDownValueDTO = DropDownHelper.getDropDownValue(dropDownValue);

			return new ResponseEntity<DropDownValueDTO>(dropDownValueDTO, HttpStatus.OK);
		} catch (NumberFormatException e) {
			return new ResponseEntity<DropDownValueDTO>(HttpStatus.BAD_REQUEST);
		} catch (NoBeanAvailableException e) {
			return new ResponseEntity<DropDownValueDTO>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/api/dropdowns/{dropdownValueId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> removeDropdownValue(@PathVariable("dropdownValueId") Long dropdownValueId) {
		dropDownService.removeDropDownValue(dropdownValueId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
