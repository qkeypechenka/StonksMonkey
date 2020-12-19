package edu.njmsd.stonksmonkey.api.dto;

public class ProfitDto {
    private final double profit;

    public ProfitDto(double profit) {
        this.profit = profit;
    }

    public double getProfit() {
        return profit;
    }
}
