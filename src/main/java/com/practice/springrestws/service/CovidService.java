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

    // @Autowired
    // ObjectMapper objectMapper;

    @Value("${covid_summary_url}")
    private String covidSummaryURL;

    @PostConstruct
    public void initialize() {
        logger.info("Inside initialize method");
        // restTemplate = new RestTemplate();
    }

    /* public CovidSummaryCountries[] getCovidSummaryData() {
        logger.debug("Inside getCovidSummaryData method");
        ResponseEntity<String> covidSummaryResult = restTemplate.getForEntity(covidSummaryURL, String.class);
        CovidSummaryCountries[] covidSummaryCountries = null;
        ArrayList<CovidSummaryCountries> covidSummaryCountriesArrayList;

        if (covidSummaryResult.getStatusCodeValue() == 200) {
            logger.info("covidSummaryResult: " + covidSummaryResult.getBody());

            try {
                JsonNode jsonNodeRoot = objectMapper.readTree(covidSummaryResult.getBody());
                JsonNode jsonNodeGlobal = jsonNodeRoot.path("Global");
                // logger.info("jsonNodeGlobal: " + jsonNodeGlobal);
                JsonNode jsonNodeCountries = jsonNodeRoot.path("Countries");
                // logger.info("jsonNodeCountries: " + jsonNodeCountries);

                covidSummaryCountriesArrayList = objectMapper.convertValue(jsonNodeCountries, ArrayList.class);
                logger.info("covidSummaryCountriesArrayList: " + covidSummaryCountriesArrayList);

                covidSummaryRepository.saveAll(covidSummaryCountriesArrayList);
                logger.info("Data saved successfully");
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        } else {
            logger.info("Status code is ==> " + covidSummaryResult.getStatusCodeValue());
        }

        return covidSummaryCountries;
    } */

    public ResponseEntity<CovidSummary> getCovidSummaryDataNew() {
        logger.info("Inside getCovidSummaryDataNew method");
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

    /* public void updateCovidSummaryData(CovidSummaryCountries covidSummaryCountries, int id) {
        logger.debug("Inside updateCovidSummaryData method");

        if (covidSummaryRepository.findById(id).isPresent()) {
            Optional<CovidSummaryCountries> covidSummaryOld = covidSummaryRepository.findById(id);
        }
    } */

}
