package com.akapush.plm.util;

import com.akapush.plm.domain.bean.AccompanyingStatistics;
import com.akapush.plm.domain.bean.GeographicStatistics;
import com.akapush.plm.domain.dto.AccompanyingStatisticsDTO;
import com.akapush.plm.domain.dto.GeographicStatisticsDTO;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class StatisticsHelper {


    public AccompanyingStatisticsDTO getAccompanyingStatisticsDTO(AccompanyingStatistics accompanyingStatistics) {
        AccompanyingStatisticsDTO accompanyingStatisticsDTO = new AccompanyingStatisticsDTO();
        Map<String, GeographicStatisticsDTO> sexStatisticsDTO = new HashMap<>();
        Map<String, GeographicStatistics> sexStatistics = accompanyingStatistics.getSexStatistics();
        sexStatistics.forEach((key, geographicStatistics) -> sexStatisticsDTO.put(key, getGeographicStatisticsDTO(geographicStatistics)));
        accompanyingStatisticsDTO.setSexStatistics(sexStatisticsDTO);
        return  accompanyingStatisticsDTO;
    }

    private GeographicStatisticsDTO getGeographicStatisticsDTO(GeographicStatistics geographicStatistics) {
        GeographicStatisticsDTO geographicStatisticsDTO = new GeographicStatisticsDTO();
        geographicStatisticsDTO.setNumberInRegion(geographicStatistics.getNumberInRegion());
        geographicStatisticsDTO.setNumberInToulouse(geographicStatistics.getNumberInToulouse());
        geographicStatisticsDTO.setNumberInToulouse(geographicStatistics.getNumberInToulouseMetropole());
        return geographicStatisticsDTO;
    }
}
