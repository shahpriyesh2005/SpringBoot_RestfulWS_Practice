package com.practice.springrestws.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@JsonIgnoreProperties(value = "Premium")
@Table(name = "covid_summary")
public class CovidSummaryCountries {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "country_code", nullable = false)
    private String countryCode;

    @Column(name = "slug", nullable = true)
    private String slug;

    @Column(name = "new_confirmed", nullable = false)
    private long newConfirmed;

    @Column(name = "total_confirmed", nullable = false)
    private long totalConfirmed;

    @Column(name = "new_deaths", nullable = false)
    private long newDeaths;

    @Column(name = "total_deaths", nullable = false)
    private long totalDeaths;

    @Column(name = "new_recovered", nullable = false)
    private long newRecovered;

    @Column(name = "total_recovered", nullable = false)
    private long totalRecovered;

    @Column(name = "date", nullable = false)
    private Date date;

    @CreatedBy
    @Column(name = "created_by", insertable = true, updatable = false, columnDefinition = "varchar(255) default 'Priyesh'")
    private String createdBy;

    @CreatedDate
    @Column(name = "created_date", insertable = true, updatable = false)
    @Temporal(TemporalType.DATE)
    private Date createdDate;

    @LastModifiedBy
    @Column(name = "last_modified_by", insertable = true, updatable = true, columnDefinition = "varchar(255) default 'Priyesh'")
    private String lastModifiedBy;

    @LastModifiedDate
    @Column(name = "last_modified_date", insertable = true, updatable = true)
    @Temporal(TemporalType.DATE)
    private Date lastModifiedDate;

    public CovidSummaryCountries() {
    }

    public CovidSummaryCountries(int id, String country, String countryCode, String slug, long newConfirmed, long totalConfirmed, long newDeaths, long totalDeaths, long newRecovered, long totalRecovered, Date date, String createdBy, Date createdDate, String lastModifiedBy, Date lastModifiedDate) {
        this.id = id;
        this.country = country;
        this.countryCode = countryCode;
        this.slug = slug;
        this.newConfirmed = newConfirmed;
        this.totalConfirmed = totalConfirmed;
        this.newDeaths = newDeaths;
        this.totalDeaths = totalDeaths;
        this.newRecovered = newRecovered;
        this.totalRecovered = totalRecovered;
        this.date = date;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.lastModifiedBy = lastModifiedBy;
        this.lastModifiedDate = lastModifiedDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    @JsonSetter("Country")
    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    @JsonSetter("CountryCode")
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getSlug() {
        return slug;
    }

    @JsonSetter("Slug")
    public void setSlug(String slug) {
        this.slug = slug;
    }

    public long getNewConfirmed() {
        return newConfirmed;
    }

    @JsonSetter("NewConfirmed")
    public void setNewConfirmed(long newConfirmed) {
        this.newConfirmed = newConfirmed;
    }

    public long getTotalConfirmed() {
        return totalConfirmed;
    }

    @JsonSetter("TotalConfirmed")
    public void setTotalConfirmed(long totalConfirmed) {
        this.totalConfirmed = totalConfirmed;
    }

    public long getNewDeaths() {
        return newDeaths;
    }

    @JsonSetter("NewDeaths")
    public void setNewDeaths(long newDeaths) {
        this.newDeaths = newDeaths;
    }

    public long getTotalDeaths() {
        return totalDeaths;
    }

    @JsonSetter("TotalDeaths")
    public void setTotalDeaths(long totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public long getNewRecovered() {
        return newRecovered;
    }

    @JsonSetter("NewRecovered")
    public void setNewRecovered(long newRecovered) {
        this.newRecovered = newRecovered;
    }

    public long getTotalRecovered() {
        return totalRecovered;
    }

    @JsonSetter("TotalRecovered")
    public void setTotalRecovered(long totalRecovered) {
        this.totalRecovered = totalRecovered;
    }

    public Date getDate() {
        return date;
    }

    @JsonSetter("Date")
    public void setDate(Date date) {
        this.date = date;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    public String toString() {
        return "Covid{" +
                "country='" + country + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", slug='" + slug + '\'' +
                ", newConfirmed=" + newConfirmed +
                ", totalConfirmed=" + totalConfirmed +
                ", newDeaths=" + newDeaths +
                ", totalDeaths=" + totalDeaths +
                ", newRecovered=" + newRecovered +
                ", totalRecovered=" + totalRecovered +
                ", date=" + date +
                '}';
    }
}
