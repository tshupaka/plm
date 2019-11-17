package com.akapush.plm.domain.exception;

import com.akapush.plm.domain.model.Young;

public class AlreadyExistingYoungException extends AlreadyExistingBeanException {

    private Young young;

    public AlreadyExistingYoungException(Young young) {
        this.young = young;
    }


    public Young getYoung() {
        return young;
    }
}
