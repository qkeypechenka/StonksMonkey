package edu.njmsd.stonksmonkey.domain.models;

public class OperationCategorySummary {
    private final OperationCategory category;
    private final double sum;

    public OperationCategorySummary(OperationCategory category, double sum) {
        this.category = category;
        this.sum = sum;
    }

    public OperationCategory getCategory() {
        return category;
    }

    public double getSum() {
        return sum;
    }
}
