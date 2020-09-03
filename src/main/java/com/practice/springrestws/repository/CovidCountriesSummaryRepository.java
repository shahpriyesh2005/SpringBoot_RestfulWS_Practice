package com.practice.springrestws.repository;

import com.practice.springrestws.model.CovidCountriesSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CovidCountriesSummaryRepository extends JpaRepository<CovidCountriesSummary, Integer> {
}
