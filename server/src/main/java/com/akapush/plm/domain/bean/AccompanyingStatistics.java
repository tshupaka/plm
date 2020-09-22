package com.akapush.plm.domain.bean;

import java.util.Map;

public class AccompanyingStatistics {
    private final Map<String, Long> sex;

    private final Map<String, Long> educationLevel;

    private final Map<String, Long> qpv;

    public AccompanyingStatistics(Map<String, Long> sex, Map<String, Long> educationLevel, Map<String, Long> qpv) {
        this.sex = sex;
        this.educationLevel = educationLevel;
        this.qpv = qpv;
    }


    public Map<String, Long> getSex() {
        return sex;
    }

    public Map<String, Long> getEducationLevel() {
        return educationLevel;
    }

    public Map<String, Long> getQpv() {
        return qpv;
    }
}

