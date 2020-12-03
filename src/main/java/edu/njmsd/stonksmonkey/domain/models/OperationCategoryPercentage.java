package edu.njmsd.stonksmonkey.domain.models;

public class OperationCategoryPercentage {
    private final OperationCategory category;
    private final double sum;
    private final double percent;

    public OperationCategoryPercentage(OperationCategory category, double sum, double percent) {
        this.category = category;
        this.sum = sum;
        this.percent = percent;
    }

    public OperationCategory getCategory() {
        return category;
    }

    public double getSum() {
        return sum;
    }

    public double getPercent() {
        return percent;
    }
}
