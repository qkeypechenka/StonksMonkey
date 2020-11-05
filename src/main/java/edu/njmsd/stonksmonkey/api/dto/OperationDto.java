package edu.njmsd.stonksmonkey.api.dto;

import java.time.LocalDate;

public class OperationDto {

    private final long id;
    private final OperationCategoryDto category;
    private final double amount;
    private final LocalDate date;

    public OperationDto(long id, OperationCategoryDto category, double amount, LocalDate date) {
        this.id = id;
        this.category = category;
        this.amount = amount;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public OperationCategoryDto getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }
}
