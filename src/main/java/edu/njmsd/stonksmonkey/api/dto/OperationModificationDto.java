package edu.njmsd.stonksmonkey.api.dto;

import java.time.LocalDate;

public class OperationModificationDto {

    private long categoryId;
    private double amount;
    private LocalDate date;

    private OperationModificationDto() {
    }

    public long getCategoryId() {
        return categoryId;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }
}
