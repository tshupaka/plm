package com.akapush.plm.service;

import com.akapush.plm.domain.bean.AccompanyingStatistics;

import java.util.List;
import java.util.Map;

/**
 * This service provide methods to handle statistics.
 *
 * @author eric
 *
 */
public interface StatisticsService {


    /**
     * Return all youngs with accompanying informations
     * @return
     */
    List<Map<String, Object>> getYoungAccompanyingStatistics();

    /** Return all youngs with awareness informations
     *
     * @return
     */
    List<Map<String, Object>> getYoungAwarenessStatistics();

    AccompanyingStatistics getAccompanyingStatistics();

    /**
     * Return all awarenesses with the number of youngs
     * @return
     */
    List<Map<String, Object>> getAwarenessStatistics();
 }
