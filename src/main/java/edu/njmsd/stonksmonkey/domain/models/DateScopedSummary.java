package edu.njmsd.stonksmonkey.domain.models;

import java.time.LocalDate;

public class DateScopedSummary {

    private final LocalDate date;
    private final double sum;

    public DateScopedSummary(LocalDate date, double sum) {
        this.date = date;
        this.sum = sum;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getSum() {
        return sum;
    }
}
