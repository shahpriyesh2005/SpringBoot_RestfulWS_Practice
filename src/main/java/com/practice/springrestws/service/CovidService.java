package com.practice.springrestws.service;

import com.practice.springrestws.model.CovidCountriesSummary;
import com.practice.springrestws.model.CovidGlobalSummary;
import com.practice.springrestws.model.CovidSummary;
import com.practice.springrestws.repository.CovidCountriesSummaryRepository;
import com.practice.springrestws.repository.CovidGlobalSummaryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class CovidService {

    private static final Logger logger = LoggerFactory.getLogger(CovidService.class);

    @Autowired
    CovidGlobalSummaryRepository covidGlobalSummaryRepository;

    @Autowired
    CovidCountriesSummaryRepository covidCountriesSummaryRepository;

    @Autowired
    RestTemplate restTemplate;

    @Value("${covid_summary_url}")
    private String covidSummaryURL;

    @PostConstruct
    public void initialize() {
        logger.info("Inside initialize method");
    }

    public ResponseEntity<CovidSummary> getCovidSummaryData() {
        logger.info("Inside getCovidSummaryData method");
        ResponseEntity<CovidSummary> covidSummaryResponseEntity = restTemplate.getForEntity(covidSummaryURL, CovidSummary.class);
        CovidGlobalSummary covidGlobalSummary;
        List<CovidCountriesSummary> covidCountriesSummaryList;

        if (covidSummaryResponseEntity.getStatusCodeValue() == 200) {
            logger.info("covidSummaryResponseEntity: " + covidSummaryResponseEntity);

            try {
                covidGlobalSummary = covidSummaryResponseEntity.getBody().getCovidGlobalSummary();
                logger.info("covidGlobalSummary: " + covidGlobalSummary.toString());

                covidCountriesSummaryList = covidSummaryResponseEntity.getBody().getCovidCountrySummaries();
                logger.info("covidCountriesSummaryList: " + covidCountriesSummaryList);

                covidGlobalSummaryRepository.save(covidGlobalSummary);
                logger.info("Covid Global Summary data saved successfully");

                covidCountriesSummaryRepository.saveAll(covidCountriesSummaryList);
                logger.info("Covid Country Summary data saved successfully");

                logger.info("Data saved successfully");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            logger.info("Status code is ==> " + covidSummaryResponseEntity.getStatusCodeValue());
        }

        return covidSummaryResponseEntity;
    }

}
