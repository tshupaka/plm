package com.akapush.plm.service.internal;

import com.akapush.plm.dao.StatisticsDAO;
import com.akapush.plm.dao.YoungDAO;
import com.akapush.plm.domain.bean.AccompanyingStatistics;
import com.akapush.plm.domain.bean.GeographicStatistics;
import com.akapush.plm.domain.model.Young;
import com.akapush.plm.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private StatisticsDAO statisticsDAO;

    @Autowired
    private YoungDAO youngDAO;

    @Override
    public List<Map<String, Object>> getYoungAccompanyingStatistics() {
        return statisticsDAO.getYoungAccompanyingStatistics();
    }

    @Override
    public List<Map<String, Object>> getYoungAwarenessStatistics() {
        return statisticsDAO.getYoungAwarenessStatistics();
    }

    @Override
    public AccompanyingStatistics getAccompanyingStatistics() {
      /*  Iterable<Young> youngs = youngDAO.getAllYWithCurrentAccompanying();
        Map<String, List<Young>> genderRepart = StreamSupport.stream(youngs.spliterator(), false).
                collect(Collectors.groupingBy((Young young) -> young.getGender().getValue()));

        genderRepart.values().stream().map( (List<Young> young1s) -> {
            young1s.stream().filter(young -> getToulouseFocus(young.getGeographicFocus().getValue()))
                    .reduce(new GeographicStatistics(0,0,0),
                    (GeographicStatistics geographicStatistics, Young young) -> {  return calculateYoung(geographicStatistics, young);
                    });
        });

        GeographicStatistics geographicStatistics = new GeographicStatistics()
        AccompanyingStatistics accompanyingStatistics = new AccompanyingStatistics();
       accompanyingStatistics.setSexStatistics(genderRepart);*/
        return null;
    }

    private Young calculateYoung(GeographicStatistics geographicStatistics, Young young) {
        return null;
    }

    private boolean getToulouseFocus(String value) {
        return  true;
    }

    @Override
    public List<Map<String, Object>> getAwarenessStatistics() {
        return statisticsDAO.getAwarnessStatistics();
    }
}
