package com.weazy.record;

import com.akapush.plm.domain.model.DropDownKey;
import com.akapush.plm.domain.model.DropDownValue;
import com.akapush.plm.domain.model.Young;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class DomainBeanGenerator {


    private static final Long GENDER_DD_KEY_ID = 1l;


    private static final Long MAN_GENDER_DD_VALUE_ID = 1l;
    private static final Long WOMAN_GENDER_DD_VALUE_ID = 2l;

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
        return young;
    }

    private static DropDownValue createGenderDropDownValue(long id) {
        if (id % 2 == 0) {
            return generateDropDownValue(GENDER_DD_KEY_ID, "gender", "Sexe", MAN_GENDER_DD_VALUE_ID, "Homme");
        } else {
            return generateDropDownValue(GENDER_DD_KEY_ID, "gender", "Sexe", WOMAN_GENDER_DD_VALUE_ID, "Femme");
        }


    }


    private static DropDownValue generateDropDownValue(Long keyId, String key, String label, Long valueId, String value) {
        DropDownValue ddValue = new DropDownValue();
        DropDownKey ddKey = new DropDownKey();
        ddKey.setKey(key);
        ddKey.setLabel(label);
        ddKey.setId(keyId);
        ddValue.setId(valueId);
        ddValue.setDropDownKey(ddKey);
        ddValue.setValue(value);
        ddValue.setDropDownKey(ddKey);
        return ddValue;
    }
}
