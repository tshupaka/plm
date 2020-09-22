package com.akapush.plm.domain.dto;

import java.util.Map;

public class AccompanyingStatisticsDTO {

    private Map<String, Integer> sex;

    private Map<String, Integer> educationLevel;

    private Map<String, Integer> qpv;


    public Map<String, Integer> getSex() {
        return sex;
    }

    public void setSex(Map<String, Integer> sex) {
        this.sex = sex;
    }

    public Map<String, Integer> getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(Map<String, Integer> educationLevel) {
        this.educationLevel = educationLevel;
    }

    public Map<String, Integer> getQpv() {
        return qpv;
    }

    public void setQpv(Map<String, Integer> qpv) {
        this.qpv = qpv;
    }
}
