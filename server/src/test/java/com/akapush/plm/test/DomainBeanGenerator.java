package com.akapush.plm.test;

import com.akapush.plm.domain.model.Accompanying;
import com.akapush.plm.domain.model.DropDownKey;
import com.akapush.plm.domain.model.DropDownValue;
import com.akapush.plm.domain.model.Young;
import com.akapush.plm.service.DropDownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


public class DomainBeanGenerator {


    private static final Long GENDER_DD_KEY_ID = 1l;


    private static final Long MAN_GENDER_DD_VALUE_ID = 1l;
    private static final Long WOMAN_GENDER_DD_VALUE_ID = 2l;
    private static DropDownValue man_gender_dd_value;
    private static DropDownValue woman_gender_dd_value;

    public static List<Young> getSampleYoungs() {
        List<Young> youngs = new ArrayList<>();
        IntStream.range(0, 30).forEach(i -> {
            Young young = createYoung(i);
            youngs.add(young);
        });
        return youngs;
    }

    private static Young createYoung(long id) {
        Young young = new Young();
        young.setId(id);
        young.setLastname("Young " + id);
        young.setGender(createGenderDropDownValue(id));
        young.setAccompanyings(createAccompanyings(id));
        young.setGeographicFocus(createGeographicFocusDropDownValue(id));
        return young;
    }

    private static List<Accompanying> createAccompanyings(long id) {
        return null;
    }

    private static DropDownValue createGeographicFocusDropDownValue(long id) {
        return null;
    }

    private  static DropDownValue createGenderDropDownValue(long id) {
        if (id % 2 == 0) {
            if (man_gender_dd_value == null) {
                man_gender_dd_value = generateDropDownValue("gender", "Sexe", "Homme");
            } else {
                return man_gender_dd_value;
            }
        } else {
            if (woman_gender_dd_value == null) {
                woman_gender_dd_value = generateDropDownValue("gender", "Sexe", "Femme");
            } else {
                return woman_gender_dd_value;
            }
        }
        return null;
    }


    private static DropDownValue generateDropDownValue(String key, String label, String value) {
        DropDownValue ddValue = new DropDownValue();
        DropDownKey ddKey = new DropDownKey();
        ddKey.setKey(key);
        ddKey.setLabel(label);
        ddValue.setDropDownKey(ddKey);
        ddValue.setValue(value);
        ddValue.setDropDownKey(ddKey);
        return ddValue;
    }
}
