package com.practice.springrestws.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Global",
        "Countries",
        "Date"
})
public class CovidSummary {

    @JsonProperty("Global")
    private CovidGlobalSummary covidGlobalSummary;
    @JsonProperty("Countries")
    private List<CovidCountriesSummary> covidCountriesSummaries = null;
    @JsonProperty("Date")
    private String date;

    /**
     * No args constructor for use in serialization
     *
     */
    public CovidSummary() {
    }

    /**
     *
     * @param date
     * @param covidGlobalSummary
     * @param covidCountriesSummaries
     */
    public CovidSummary(CovidGlobalSummary covidGlobalSummary, List<CovidCountriesSummary> covidCountriesSummaries, String date) {
        super();
        this.covidGlobalSummary = covidGlobalSummary;
        this.covidCountriesSummaries = covidCountriesSummaries;
        this.date = date;
    }

    @JsonProperty("Global")
    public CovidGlobalSummary getCovidGlobalSummary() {
        return covidGlobalSummary;
    }

    @JsonProperty("Global")
    public void setGlobal(CovidGlobalSummary covidGlobalSummary) {
        this.covidGlobalSummary = covidGlobalSummary;
    }

    @JsonProperty("Countries")
    public List<CovidCountriesSummary> getCovidCountrySummaries() {
        return covidCountriesSummaries;
    }

    @JsonProperty("Countries")
    public void setCountries(List<CovidCountriesSummary> covidCountriesSummaries) {
        this.covidCountriesSummaries = covidCountriesSummaries;
    }

    @JsonProperty("Date")
    public String getDate() {
        return date;
    }

    @JsonProperty("Date")
    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "CovidSummary{" +
                "covidGlobalSummary=" + covidGlobalSummary +
                ", covidCountriesSummaries=" + covidCountriesSummaries +
                ", date='" + date +
                '}';
    }
}
