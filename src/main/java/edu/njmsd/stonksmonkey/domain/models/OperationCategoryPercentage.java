package edu.njmsd.stonksmonkey.domain.models;

public class OperationCategoryPercentage {
    private final OperationCategorySummary summary;
    private final double percent;

    public OperationCategoryPercentage(OperationCategorySummary summary, double percent) {
        this.summary = summary;
        this.percent = percent;
    }

    public OperationCategorySummary getSummary() {
        return summary;
    }

    public double getPercent() {
        return percent;
    }
}
