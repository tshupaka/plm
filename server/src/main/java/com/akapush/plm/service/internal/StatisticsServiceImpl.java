package com.akapush.plm.service.internal;

import com.akapush.plm.dao.StatisticsDAO;
import com.akapush.plm.dao.YoungDAO;
import com.akapush.plm.domain.bean.AccompanyingStatistics;
import com.akapush.plm.domain.bean.AwarenessStatistics;
import com.akapush.plm.domain.bean.GeographicStatistics;
import com.akapush.plm.domain.model.DropDownValue;
import com.akapush.plm.domain.model.Young;
import com.akapush.plm.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
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
    public AccompanyingStatistics getAccompanyingStatistics(List<Integer> years, List<Long> geographicFocusIds, List<Long> foundingIds) {
        Iterable<Young> youngs = youngDAO.getAllYWithCurrentAccompanying();

        List<Young> filteredYoungs = StreamSupport
                .stream(youngs.spliterator(), false)
                .filter(young -> filterYoung(young, years, geographicFocusIds, foundingIds))
                .collect(Collectors.toList());

        Map<String, Long> genderRepart = filteredYoungs.stream()
                .collect(Collectors.groupingBy((Young young) -> young.getGender().getValue(), Collectors.counting()));


        Map<String, Long> qpvRepart = filteredYoungs.stream()
                .collect(Collectors.groupingBy((Young young) -> young.getQpvStatus().getValue(), Collectors.counting()));


        Map<String, Long> educationLevelRepart = filteredYoungs.stream()
                .collect(Collectors.groupingBy((Young young) -> young.getEducationLevel().getValue(), Collectors.counting()));

        return new AccompanyingStatistics(genderRepart, educationLevelRepart, qpvRepart);
    }

    private boolean filterYoung(Young young, List<Integer> years, List<Long> geographicFocusIds, List<Long> foundingIds) {
        boolean result = true;
        if (young.getAccompanyings() != null) {
            result &= young.getAccompanyings().stream()
                    .filter(accompanying -> foundingIds
                            .contains(Optional.ofNullable(accompanying.getFounding()).orElse(new DropDownValue()).getId()))
                    .flatMap(accompanying -> accompanying.getMeetings().stream())
                    .map(meeting -> getDateYear(meeting.getDate()))
                    .anyMatch(year -> years.contains(year));
        }
        if (young.getGeographicFocus() != null) {
            result &= geographicFocusIds.contains(young.getGeographicFocus().getId());
        }
        return result;

    }

    private Integer getDateYear(Date date) {
        if (date != null) {
            return date.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate().getYear();
        }
        return null;
    }

    private Young calculateYoung(GeographicStatistics geographicStatistics, Young young) {
        return null;
    }

    private boolean getToulouseFocus(String value) {
        return true;
    }

    @Override
    public List<Map<String, Object>> exportAwarenessStatistics() {
        return statisticsDAO.exportAwarnessStatistics();
    }

    @Override
    public AwarenessStatistics getAwarenessStatistics(List<Integer> qpvIds) {
        return null;
    }
}
