package com.akapush.plm.service;

import com.akapush.plm.domain.bean.AccompanyingStatistics;
import com.akapush.plm.domain.bean.AwarenessStatistics;

import java.util.List;
import java.util.Map;

/**
 * This service provide methods to handle statistics.
 *
 * @author eric
 */
public interface StatisticsService {


    /**
     * Return all youngs with accompanying informations
     *
     * @return
     */
    List<Map<String, Object>> getYoungAccompanyingStatistics();

    /**
     * Return all youngs with awareness informations
     *
     * @return
     */
    List<Map<String, Object>> getYoungAwarenessStatistics();

    /**
     * Return statistcs of accompanyings
     *
     * @param years
     * @param geographicFocusIds
     * @param foundingIds
     * @return
     */
    public AccompanyingStatistics getAccompanyingStatistics(List<Integer> years, List<Long> geographicFocusIds, List<Long> foundingIds);

    /**
     * Return all awarenesses with the number of youngs
     *
     * @return
     */
    List<Map<String, Object>> exportAwarenessStatistics();

    /**
     * Return statistics of Awareness
     *
     * @param years
     * @param geographicFocusIds
     * @return
     */
    AwarenessStatistics getAwarenessStatistics(List<Integer> years, List<Long> geographicFocusIds);
}
