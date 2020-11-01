package edu.njmsd.stonksmonkey.domain.models;

import java.time.LocalDate;

public class Operation {

    private final long id;
    private final long userId;
    private final OperationCategory category;
    private final double amount;
    private final LocalDate date;

    public Operation(long id, long userId, OperationCategory category, double amount, LocalDate date) {
        this.id = id;
        this.userId = userId;
        this.category = category;
        this.amount = amount;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }

    public OperationCategory getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }
}
