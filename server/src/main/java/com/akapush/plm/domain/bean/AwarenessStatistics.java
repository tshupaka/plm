package com.akapush.plm.domain.bean;

import java.util.Map;

public class AwarenessStatistics {

    private final Map<String, Long> sex;

    private final Map<String, Long> qpv;

    public AwarenessStatistics(Map<String, Long> sex, Map<String, Long> qpv) {
        this.sex = sex;
        this.qpv = qpv;
    }

    public Map<String, Long> getSex() {
        return sex;
    }

    public Map<String, Long> getQpv() {
        return qpv;
    }
}
