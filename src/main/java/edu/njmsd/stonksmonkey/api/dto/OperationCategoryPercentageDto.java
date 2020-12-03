package edu.njmsd.stonksmonkey.api.dto;

public class OperationCategoryPercentageDto extends OperationCategorySummaryDto {

    private OperationCategoryDto category;
    private int sum;
    private double percent;

    public OperationCategoryDto getCategory() {
        return category;
    }

    public void setCategory(OperationCategoryDto category) {
        this.category = category;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }
}
