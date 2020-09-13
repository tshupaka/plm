package com.akapush.plm.domain.dto;

import com.akapush.plm.domain.bean.GeographicStatistics;

import java.util.Map;

public class AccompanyingStatisticsDTO {

    private Map<String, GeographicStatisticsDTO> sexStatistics;


    public Map<String, GeographicStatisticsDTO> getSexStatistics() {
        return sexStatistics;
    }

    public void setSexStatistics(Map<String, GeographicStatisticsDTO> sexStatistics) {
        this.sexStatistics = sexStatistics;
    }
}
