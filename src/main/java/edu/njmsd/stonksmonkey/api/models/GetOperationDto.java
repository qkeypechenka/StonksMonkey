package edu.njmsd.stonksmonkey.api.models;


public class GetOperationDto {

    private final long id;
    private final double amount;
    private final String category;
    private final String type;

    public GetOperationDto(long id, double amount, String category, String type) {
        this.id = id;
        this.amount = amount;
        this.category = category;
        this.type = type;
    }

    public long getId() {
        return id;
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
