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

    public AccompanyingStatistics getAccompanyingStatistics(List<Integer> years, List<Long> geographicFocusIds, List<Long> foundingIds);

    /**
     * Return all awarenesses with the number of youngs
     *
     * @return
     */
    List<Map<String, Object>> exportAwarenessStatistics();

    /**
     * Return statistics about awareness
     *
     * @param qpvIds filter by qpvIds
     * @return awrenesses statistics
     */
    AwarenessStatistics getAwarenessStatistics(List<Integer> qpvIds);
}
