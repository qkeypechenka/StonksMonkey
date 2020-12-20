package edu.njmsd.stonksmonkey.api.dto;

import java.time.LocalDate;

public class OperationModificationDto {

    private Long categoryId;
    private double amount;
    private LocalDate date;

    private OperationModificationDto() {
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }
}
