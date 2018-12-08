package com.akapush.plm.service.internal;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akapush.plm.dao.DropDownDAO;
import com.akapush.plm.domain.model.DropDownKey;
import com.akapush.plm.domain.model.DropDownValue;
import com.akapush.plm.service.DropDownService;

@Service
public class DropDownServiceImpl implements DropDownService {

	@Autowired
	private DropDownDAO dropDownDAO;

	@Override
	public Map<DropDownKey, List<DropDownValue>> getDropDownValues() {
		Iterable<DropDownKey> dropDownKeys = dropDownDAO.findAll();
		Map<DropDownKey, List<DropDownValue>> mapDropDownValues = new HashMap<DropDownKey, List<DropDownValue>>();
		for (DropDownKey dropDownKey : dropDownKeys) {
			List<DropDownValue> dropDownValues = dropDownKey.getDropDownValues();
			dropDownValues.sort(Comparator.comparing(DropDownValue::getOrder));
			mapDropDownValues.put(dropDownKey, dropDownValues);
		}
		return mapDropDownValues;
	}

}
