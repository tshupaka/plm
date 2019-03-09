package com.akapush.plm.service.internal;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akapush.plm.dao.DropDownKeyDAO;
import com.akapush.plm.dao.DropDownValueDAO;
import com.akapush.plm.domain.enumartion.BeanType;
import com.akapush.plm.domain.exception.NoBeanAvailableException;
import com.akapush.plm.domain.model.DropDownKey;
import com.akapush.plm.domain.model.DropDownValue;
import com.akapush.plm.service.DropDownService;

@Service
public class DropDownServiceImpl implements DropDownService {

	@Autowired
	private DropDownKeyDAO dropDownKeyDAO;

	@Autowired
	private DropDownValueDAO dropDownValueDAO;

	@Override
	public Iterable<DropDownKey> getDropDownValues() {
		Iterable<DropDownKey> dropDownKeys = dropDownKeyDAO.findAll();
		for (DropDownKey dropDownKey : dropDownKeys) {
			List<DropDownValue> dropDownValues = dropDownKey.getDropDownValues();
			dropDownValues.sort(Comparator.comparing(DropDownValue::getOrder));

		}
		return dropDownKeys;
	}

	@Override
	public DropDownValue addNewValue(String key, String value, Integer order) throws NoBeanAvailableException {
		DropDownKey dropDownKey = dropDownKeyDAO.findByKey(key);
		if (dropDownKey == null) {
			throw new NoBeanAvailableException(BeanType.DROPDOWN_KEY, key);
		}
		DropDownValue dropDownValue = new DropDownValue();
		dropDownValue.setValue(value);
		dropDownValue.setDropDownKey(dropDownKey);
		dropDownValue.setOrder(order);
		DropDownValue dropDownValueSave = dropDownValueDAO.save(dropDownValue);
		return dropDownValueSave;
	}

	@Override
	public void removeDropDownValue(Long dropdownValueId) {
		DropDownValue dropdownValue = new DropDownValue();
		dropdownValue.setId(dropdownValueId);
		dropDownValueDAO.delete(dropdownValue);

	}

}
