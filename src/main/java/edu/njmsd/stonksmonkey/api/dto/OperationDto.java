package edu.njmsd.stonksmonkey.api.dto;

import java.time.LocalDate;

public class OperationDto {

    private long id;
    private OperationCategoryDto category;
    private double amount;
    private LocalDate date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public OperationCategoryDto getCategory() {
        return category;
    }

    public void setCategory(OperationCategoryDto category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
