package edu.njmsd.stonksmonkey.domain.stats;

import edu.njmsd.stonksmonkey.domain.models.Operation;
import edu.njmsd.stonksmonkey.domain.models.OperationCategoryPercentage;
import edu.njmsd.stonksmonkey.domain.models.OperationCategorySummary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OperationCategoryStatisticsCalculator {

    public List<OperationCategorySummary> sumByCategory(List<Operation> operations) {
        return operations.stream()
                .filter(o -> o.getCategory() != null)
                .collect(Collectors.groupingBy(Operation::getCategory, Collectors.summingDouble(Operation::getAmount)))
                .entrySet().stream().map(e -> new OperationCategorySummary(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

    public List<OperationCategoryPercentage> getPercentageByCategory(List<Operation> operations) {
        var sum = sumByCategory(operations);
        var total = (Double) sum.stream().mapToDouble(OperationCategorySummary::getSum).sum();
        return sum.stream()
                .map(s -> new OperationCategoryPercentage(s.getCategory(), s.getSum(), s.getSum() / total))
                .collect(Collectors.toList());
    }
}
