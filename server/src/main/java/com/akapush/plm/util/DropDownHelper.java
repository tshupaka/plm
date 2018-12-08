package com.akapush.plm.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.akapush.plm.domain.dto.DropDownValueDTO;
import com.akapush.plm.domain.model.DropDownKey;
import com.akapush.plm.domain.model.DropDownValue;

/**
 * This classe provide helper to convert {@link DropDownValue} bean to
 * {@link DropDownValueDTO}.
 * 
 * @author eric
 *
 */
public class DropDownHelper {

	public static Map<String, List<DropDownValueDTO>> getDrowDownValuesDTO(
			Map<DropDownKey, List<DropDownValue>> mapDropDownValues) {
		Map<String, List<DropDownValueDTO>> mapDropDownValuesDTO = new HashMap<String, List<DropDownValueDTO>>();
		for (Entry<DropDownKey, List<DropDownValue>> entry : mapDropDownValues.entrySet()) {
			DropDownKey dropDownKey = entry.getKey();
			List<DropDownValue> dropDownValues = entry.getValue();
			mapDropDownValuesDTO.put(dropDownKey.getKey(), convertDropDownValues(dropDownValues));
		}
		return mapDropDownValuesDTO;
	}

	private static List<DropDownValueDTO> convertDropDownValues(List<DropDownValue> dropDownValues) {
		List<DropDownValueDTO> dropDownValuesDTO = new ArrayList<DropDownValueDTO>();
		for (DropDownValue dropDownValue : dropDownValues) {
			dropDownValuesDTO.add(convertDropDownValue(dropDownValue));
		}
		return dropDownValuesDTO;
	}

	private static DropDownValueDTO convertDropDownValue(DropDownValue dropDownValue) {
		DropDownValueDTO dropDownValueDTO = new DropDownValueDTO();
		dropDownValueDTO.setValue(dropDownValue.getValue());
		dropDownValueDTO.setOrder(dropDownValue.getOrder());
		dropDownValueDTO.setId(dropDownValue.getId());
		return dropDownValueDTO;
	}

}
