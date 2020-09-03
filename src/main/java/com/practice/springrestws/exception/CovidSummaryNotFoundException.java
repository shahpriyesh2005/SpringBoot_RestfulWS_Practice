package com.practice.springrestws.exception;

public class CovidSummaryNotFoundException extends RuntimeException {
    public CovidSummaryNotFoundException(String type, int id) {
        super("Could not find Covid " + type + " Summary for id " + id);
    }
}
