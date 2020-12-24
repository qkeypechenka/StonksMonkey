package edu.njmsd.stonksmonkey.domain.models;

import java.time.LocalDate;

public class DateScopedProfit {

    private final LocalDate date;
    private final double profit;

    public DateScopedProfit(LocalDate date, double profit) {
        this.date = date;
        this.profit = profit;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getProfit() {
        return profit;
    }
}
