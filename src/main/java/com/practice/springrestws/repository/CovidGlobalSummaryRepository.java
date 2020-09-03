package com.practice.springrestws.repository;

import com.practice.springrestws.model.CovidGlobalSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CovidGlobalSummaryRepository extends JpaRepository<CovidGlobalSummary, Integer> {
}
