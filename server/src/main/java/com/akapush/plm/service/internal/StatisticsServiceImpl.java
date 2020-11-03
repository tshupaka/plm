package com.akapush.plm.service.internal;

import com.akapush.plm.dao.StatisticsDAO;
import com.akapush.plm.dao.YoungDAO;
import com.akapush.plm.domain.bean.AccompanyingStatistics;
import com.akapush.plm.domain.bean.AwarenessStatistics;
import com.akapush.plm.domain.model.DropDownKey;
import com.akapush.plm.domain.model.DropDownValue;
import com.akapush.plm.domain.model.Meeting;
import com.akapush.plm.domain.model.Young;
import com.akapush.plm.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    private static final DropDownValue DEFAULT_DROP_DOWN_VALUE = new DropDownValue();
    @Autowired
    private StatisticsDAO statisticsDAO;

    @Autowired
    private YoungDAO youngDAO;

    @PostConstruct
    void initService(){
        DEFAULT_DROP_DOWN_VALUE.setId(-1l);
        DEFAULT_DROP_DOWN_VALUE.setValue("Non défini");
    }

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
        Iterable<Young> youngs = youngDAO.getAllYoungsYWithCurrentAccompanying();

        List<Young> filteredYoungs = StreamSupport
                .stream(youngs.spliterator(), false)
                .filter(young -> filterAccompanyingYoung(young, years, geographicFocusIds, foundingIds))
                .collect(Collectors.toList());

        Map<String, Long> genderRepart = filteredYoungs.stream()
                .collect(Collectors.groupingBy((Young young) -> young.getGender().getValue(), Collectors.counting()));


        Map<String, Long> qpvRepart = filteredYoungs.stream()
                .collect(Collectors.groupingBy((Young young) -> getQpvStatus(young), Collectors.counting()));


        Map<String, Long> educationLevelRepart = filteredYoungs.stream()
                .collect(
                        Collectors.collectingAndThen(
                        Collectors.groupingBy((Young young) -> getEducationLevel(young),
                                Collectors.counting()), this::treeMap
                        ));

        filteredYoungs.stream().forEach(young -> System.out.println(young.getLastname()));
        return new AccompanyingStatistics(genderRepart, educationLevelRepart, qpvRepart);
    }

    private Map<String, Long> treeMap(Map<DropDownValue, Long> map) {
        Map<String, Long> stringTreeMap = new LinkedHashMap<>();
        Map<DropDownValue, Long> treeMap = new TreeMap<>(map);
        treeMap.forEach((key, value)-> stringTreeMap.put(key.getValue(), value) );
        return stringTreeMap;
    }


    @Override
    public AwarenessStatistics getAwarenessStatistics(List<Integer> years, List<Long> geographicFocusIds) {
        Iterable<Young> youngs = youngDAO.getAllYoungsWithAwareness();
        List<Young> filteredYoungs = StreamSupport
                .stream(youngs.spliterator(), false)
                .filter(young -> filterAwarenessYoung(young, years, geographicFocusIds))
                .collect(Collectors.toList());

        Map<String, Long> genderRepart = filteredYoungs.stream()
                .collect(Collectors.groupingBy((Young young) -> getGender(young), Collectors.counting()));


        Map<String, Long> qpvRepart = filteredYoungs.stream()
                .collect(Collectors.groupingBy((Young young) -> getQpvStatus(young), Collectors.counting()));

        return new AwarenessStatistics(genderRepart, qpvRepart);
    }

    private String getQpvStatus(Young young) {
        return Optional.ofNullable(young.getQpvStatus())
                .map(dropDownValue -> dropDownValue.getValue())
                .orElse("Non défini");

    }

    private DropDownValue getEducationLevel(Young young) {
        return Optional.ofNullable(young.getEducationLevel())
                .orElse(DEFAULT_DROP_DOWN_VALUE);
    }

    private String getGender(Young young) {
        return Optional.ofNullable(young.getGender())
                .map(dropDownValue -> dropDownValue.getValue())
                .orElse("Non défini");
    }


    private boolean filterAwarenessYoung(Young young, List<Integer> years, List<Long> geographicFocusIds) {
        boolean result = true;
        if (young.getAwarenesses() != null) {
            result &= young.getAwarenesses().stream()
                    .map(awareness -> getDateYear(awareness.getDate()))
                    .anyMatch(year -> years.contains(year));
        }
        if (young.getGeographicFocus() != null) {
            result &= geographicFocusIds.contains(young.getGeographicFocus().getId());
        } else {
            result &= geographicFocusIds.contains(-1l);
        }
        return result;
    }


    private boolean filterAccompanyingYoung(Young young, List<Integer> years, List<Long> geographicFocusIds, List<Long> foundingIds) {
        boolean result = true;
        DropDownValue emptyDropDown = new DropDownValue();
        emptyDropDown.setId(-1l);
        if (young.getAccompanyings() != null) {
            List<Meeting> emptyMeetings = Arrays.asList(new Meeting());
            result &= young.getAccompanyings().stream()
                    .filter(accompanying -> foundingIds
                            .contains(Optional.ofNullable(accompanying.getFounding()).orElse(emptyDropDown).getId()))
                    .flatMap(accompanying -> {
                        List<Meeting> meetings = accompanying.getMeetings();
                        if (meetings != null && meetings.size() > 0) {
                            return meetings.stream();
                        } else {
                            return emptyMeetings.stream();
                        }

                    })
                    .map(meeting -> getDateYear(meeting.getDate()))
                    .anyMatch(year -> years.contains(year));
        } else {
            result = false;
        }
        if (young.getGeographicFocus() != null) {
            result &= geographicFocusIds.contains(young.getGeographicFocus().getId());
        } else {
            result &= geographicFocusIds.contains(-1l);
        }
        return result;

    }


    @Override
    public List<Map<String, Object>> exportAwarenessStatistics() {
        return statisticsDAO.exportAwarnessStatistics();
    }

    private Integer getDateYear(Date date) {
        if (date != null) {
            return date.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate().getYear();
        }
        return -1;
    }


}
