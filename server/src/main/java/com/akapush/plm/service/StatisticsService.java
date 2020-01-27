package com.akapush.plm.service;

import java.util.List;
import java.util.Map;

public interface StatisticsService {


    List<Map<String, Object>> getAccompanyingStatistics();

    List<Map<String, Object>> getYoungAwarenessStatistics();

    List<Map<String, Object>> getAwarenessStatistics();
 }
