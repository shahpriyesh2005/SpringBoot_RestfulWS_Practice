package com.practice.springrestws.controller;

import com.practice.springrestws.exception.CovidSummaryNotFoundException;
import com.practice.springrestws.model.CovidCountriesSummary;
import com.practice.springrestws.model.CovidGlobalSummary;
import com.practice.springrestws.model.CovidSummary;
import com.practice.springrestws.repository.CovidCountriesSummaryRepository;
import com.practice.springrestws.repository.CovidGlobalSummaryRepository;
import com.practice.springrestws.service.CovidService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/covid")
public class CovidController {

    private static final Logger logger = LoggerFactory.getLogger(CovidController.class);

    @Autowired
    CovidService covidService;

    @Autowired
    CovidGlobalSummaryRepository covidGlobalSummaryRepository;

    @Autowired
    CovidCountriesSummaryRepository covidCountriesSummaryRepository;

    @RequestMapping(value = "/summary", method = RequestMethod.GET)
    @ResponseBody ResponseEntity<CovidSummary> getCovidSummary() {
        logger.info("Inside getCovidSummary method");
        return covidService.getCovidSummaryDataNew();
    }

    @RequestMapping(value = "/summary/global", method = RequestMethod.GET)
    List<CovidGlobalSummary> getCovidGlobalSummary() {
        logger.info("Inside getCovidGlobalSummary method");
        return covidGlobalSummaryRepository.findAll();
    }

    @RequestMapping(value = "/summary/countries", method = RequestMethod.GET)
    List<CovidCountriesSummary> getCovidCountriesSummary() {
        logger.info("Inside getCovidCountriesSummary method");
        return covidCountriesSummaryRepository.findAll();
    }

    @RequestMapping(value = "/summary/country/{id}", method = RequestMethod.GET)
    CovidCountriesSummary getCovidCountriesSummary(@PathVariable int id) throws CovidSummaryNotFoundException {
        logger.info("Inside getCovidCountriesSummary method");
        return covidCountriesSummaryRepository.findById(id).orElseThrow(() -> new CovidSummaryNotFoundException("Country", id));
    }

    @RequestMapping(value = "/summary/global", method = RequestMethod.POST)
    CovidGlobalSummary saveCovidGlobalSummary(@RequestBody CovidGlobalSummary covidGlobalSummary) {
        logger.info("Inside saveCovidGlobalSummary method");
        return covidGlobalSummaryRepository.save(covidGlobalSummary);
    }

    @RequestMapping(value = "/summary/country", method = RequestMethod.POST)
    CovidCountriesSummary saveCovidCountriesSummary(@RequestBody CovidCountriesSummary covidCountriesSummary) {
        logger.info("Inside saveCovidCountriesSummary method");
        return covidCountriesSummaryRepository.save(covidCountriesSummary);
    }

    @RequestMapping(value = "/summary/global/{id}", method = RequestMethod.PUT)
    CovidGlobalSummary updateCovidGlobalSummary(@RequestBody CovidGlobalSummary covidGlobalSummary, @PathVariable int id) {
        logger.debug("Inside updateCovidGlobalSummary method");
        return covidGlobalSummaryRepository.findById(id)
                .map(globalSummary -> {
                    globalSummary.setNewConfirmed(covidGlobalSummary.getNewConfirmed());
                    globalSummary.setNewDeaths(covidGlobalSummary.getNewConfirmed());
                    globalSummary.setNewRecovered(covidGlobalSummary.getNewRecovered());
                    globalSummary.setTotalConfirmed(covidGlobalSummary.getTotalConfirmed());
                    globalSummary.setTotalDeaths(covidGlobalSummary.getTotalDeaths());
                    globalSummary.setTotalRecovered(covidGlobalSummary.getTotalRecovered());
                    return covidGlobalSummaryRepository.save(globalSummary);
                }).orElseThrow(() -> new CovidSummaryNotFoundException("Global", id));
    }

    @RequestMapping(value = "/summary/country/{id}", method = RequestMethod.PUT)
    CovidCountriesSummary updateCovidCountriesSummary(@RequestBody CovidCountriesSummary covidCountriesSummary, @PathVariable int id) {
        logger.debug("Inside updateCovidCountriesSummary method");
        return covidCountriesSummaryRepository.findById(id)
                .map(countrySummary -> {
                    countrySummary.setCountry(covidCountriesSummary.getCountry());
                    countrySummary.setCountryCode(covidCountriesSummary.getCountryCode());
                    countrySummary.setDate(covidCountriesSummary.getDate());
                    countrySummary.setNewConfirmed(covidCountriesSummary.getNewConfirmed());
                    countrySummary.setNewDeaths(covidCountriesSummary.getNewDeaths());
                    countrySummary.setNewRecovered(covidCountriesSummary.getNewRecovered());
                    countrySummary.setSlug(covidCountriesSummary.getSlug());
                    countrySummary.setTotalConfirmed(covidCountriesSummary.getTotalConfirmed());
                    countrySummary.setTotalDeaths(covidCountriesSummary.getTotalDeaths());
                    countrySummary.setTotalRecovered(covidCountriesSummary.getTotalRecovered());
                    return covidCountriesSummaryRepository.save(countrySummary);
                }).orElseThrow(() -> new CovidSummaryNotFoundException("Country", id));
    }

    @RequestMapping(value = "/summary/global/{id}", method = RequestMethod.DELETE)
    void deleteCovidGlobalSummary(@PathVariable int id) {
        logger.debug("Inside deleteCovidGlobalSummary method");
        covidGlobalSummaryRepository.deleteById(id);
    }

    @RequestMapping(value = "/summary/country/{id}", method = RequestMethod.DELETE)
    void deleteCovidCountriesSummary(@PathVariable int id) {
        logger.debug("Inside deleteCovidCountriesSummary method");
        covidCountriesSummaryRepository.deleteById(id);
    }

}
