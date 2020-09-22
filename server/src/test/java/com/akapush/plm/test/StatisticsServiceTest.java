package com.akapush.plm.test;

import com.akapush.plm.domain.bean.AccompanyingStatistics;
import com.akapush.plm.domain.exception.AlreadyExistingYoungException;
import com.akapush.plm.domain.exception.InvalidBeanException;
import com.akapush.plm.domain.model.Young;
import com.akapush.plm.service.StatisticsService;
import com.akapush.plm.service.YoungService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class StatisticsServiceTest {

    @Autowired
    private
    StatisticsService statisticsService;

    @Autowired
    private YoungService youngService;

    //@Test
    public void testStatistics() {
        List<Young> youngs = DomainBeanGenerator.getSampleYoungs();
        youngs.forEach(young -> {
            try {
                youngService.saveYoung(young,true);
            } catch (InvalidBeanException e) {
                e.printStackTrace();
            } catch (AlreadyExistingYoungException e) {
                e.printStackTrace();
            }
        });

        //AccompanyingStatistics statistics = statisticsService.getAccompanyingStatistics(List.of(2019), );
        //System.out.println(statistics);
    }



}
