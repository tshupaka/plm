package com.akapush.plm.domain.dto;

import java.util.Map;

public class AccompanyingStatisticsDTO {

    private Map<String, Long> sex;

    private Map<String, Long> educationLevel;

    private Map<String, Long> qpv;


    public Map<String, Long> getSex() {
        return sex;
    }

    public void setSex(Map<String, Long> sex) {
        this.sex = sex;
    }

    public Map<String, Long> getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(Map<String, Long> educationLevel) {
        this.educationLevel = educationLevel;
    }

    public Map<String, Long> getQpv() {
        return qpv;
    }

    public void setQpv(Map<String, Long> qpv) {
        this.qpv = qpv;
    }
}
