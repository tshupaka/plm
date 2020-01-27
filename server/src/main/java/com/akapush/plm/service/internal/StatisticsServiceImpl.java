package com.akapush.plm.service.internal;

import com.akapush.plm.dao.StatisticsDAO;
import com.akapush.plm.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    StatisticsDAO statisticsDAO;

    @Override
    public List<Map<String, Object>> getAccompanyingStatistics() {
        return statisticsDAO.getAccompanyingStatistics();
    }

    @Override
    public List<Map<String, Object>> getYoungAwarenessStatistics() {
        return statisticsDAO.getYoungAwarenessStatistics();
    }

    @Override
    public List<Map<String, Object>> getAwarenessStatistics() {
        return statisticsDAO.getAwarnessStatistics();
    }
}
