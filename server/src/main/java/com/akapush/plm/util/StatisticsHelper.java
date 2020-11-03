package com.akapush.plm.util;

import com.akapush.plm.domain.bean.AccompanyingStatistics;
import com.akapush.plm.domain.bean.AwarenessStatistics;
import com.akapush.plm.domain.bean.GeographicStatistics;
import com.akapush.plm.domain.dto.AccompanyingStatisticsDTO;
import com.akapush.plm.domain.dto.AwarenessStatisticsDTO;
import com.akapush.plm.domain.dto.GeographicStatisticsDTO;
import org.springframework.stereotype.Component;

@Component
public class StatisticsHelper {


    public AccompanyingStatisticsDTO getAccompanyingStatisticsDTO(AccompanyingStatistics accompanyingStatistics) {
        if(accompanyingStatistics == null) {
            return null;
        }
        AccompanyingStatisticsDTO accompanyingStatisticsDTO = new AccompanyingStatisticsDTO();
        accompanyingStatisticsDTO.setEducationLevel(accompanyingStatistics.getEducationLevel());
        accompanyingStatisticsDTO.setQpv(accompanyingStatistics.getQpv());
        accompanyingStatisticsDTO.setSex(accompanyingStatistics.getSex());
        return accompanyingStatisticsDTO;
    }


    public AwarenessStatisticsDTO getAwarenessStatisticsDTO(AwarenessStatistics awarnessStatistics) {
        if(awarnessStatistics == null) {
            return null;
        }
        AwarenessStatisticsDTO awarenessStatisticsDTO = new AwarenessStatisticsDTO();
        awarenessStatisticsDTO.setQpv(awarnessStatistics.getQpv());
        awarenessStatisticsDTO.setSex(awarnessStatistics.getSex());
        return awarenessStatisticsDTO;
    }
}
