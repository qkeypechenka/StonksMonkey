package edu.njmsd.stonksmonkey.api.dto;

public class OperationCategorySummaryDto {

    private OperationCategoryDto category;
    private int sum;

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
}
