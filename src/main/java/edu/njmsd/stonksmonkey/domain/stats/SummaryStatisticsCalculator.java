package edu.njmsd.stonksmonkey.domain.stats;

import edu.njmsd.stonksmonkey.domain.models.Operation;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SummaryStatisticsCalculator {

    public double calculateProfit(List<Operation> incomes, List<Operation> expenses) {
        return sumAmounts(incomes) - sumAmounts(expenses);
    }

    private static double sumAmounts(List<Operation> operations) {
        return operations.stream().map(Operation::getAmount).reduce(Double::sum).orElse(0.0);
    }
}
