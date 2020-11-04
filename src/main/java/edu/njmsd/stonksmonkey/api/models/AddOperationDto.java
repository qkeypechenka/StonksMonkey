package edu.njmsd.stonksmonkey.api.models;

import com.sun.istack.NotNull;

public class AddOperationDto {

    @NotNull
    private final double amount;

    @NotNull
    private final String category;

    @NotNull
    private final String type;

    public AddOperationDto(double amount, String category, String type) {
        this.amount = amount;
        this.category = category;
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public String getType() {
        return type;
    }
}
