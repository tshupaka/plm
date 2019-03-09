package com.akapush.plm.util;

import java.util.ArrayList;
import java.util.List;

import com.akapush.plm.domain.dto.DropDownKeyDTO;
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

	public static List<DropDownKeyDTO> getDrowDownKeyDTO(Iterable<DropDownKey> dropDownKeys) {
		List<DropDownKeyDTO> dropDownKeysDTO = new ArrayList<DropDownKeyDTO>();
		for (DropDownKey dropDownKey : dropDownKeys) {

			List<DropDownValue> dropDownValues = dropDownKey.getDropDownValues();
			List<DropDownValueDTO> dropDownValuesDTO = convertDropDownValues(dropDownValues);
			String key = dropDownKey.getKey();
			String label = dropDownKey.getLabel();
			DropDownKeyDTO dropDownKeyDTO = new DropDownKeyDTO();
			dropDownKeyDTO.setKey(key);
			dropDownKeyDTO.setLabel(label);
			dropDownKeyDTO.setValues(dropDownValuesDTO);
			dropDownKeysDTO.add(dropDownKeyDTO);
		}
		return dropDownKeysDTO;
	}

	public static DropDownValueDTO getDropDownValue(DropDownValue dropDownValue) {
		DropDownValueDTO dropDownValueDTO = new DropDownValueDTO();
		dropDownValueDTO.setValue(dropDownValue.getValue());
		dropDownValueDTO.setOrder(dropDownValue.getOrder());
		dropDownValueDTO.setId(dropDownValue.getId());
		return dropDownValueDTO;
	}

	private static List<DropDownValueDTO> convertDropDownValues(List<DropDownValue> dropDownValues) {
		List<DropDownValueDTO> dropDownValuesDTO = new ArrayList<DropDownValueDTO>();
		for (DropDownValue dropDownValue : dropDownValues) {
			dropDownValuesDTO.add(getDropDownValue(dropDownValue));
		}
		return dropDownValuesDTO;
	}

}
