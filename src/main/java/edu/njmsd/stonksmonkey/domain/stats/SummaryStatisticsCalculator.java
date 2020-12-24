package edu.njmsd.stonksmonkey.domain.stats;

import edu.njmsd.stonksmonkey.domain.models.DateScope;
import edu.njmsd.stonksmonkey.domain.models.DateScopedProfit;
import edu.njmsd.stonksmonkey.domain.models.DateScopedSummary;
import edu.njmsd.stonksmonkey.domain.models.Operation;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class SummaryStatisticsCalculator {

    public List<DateScopedSummary> sumAmounts(List<Operation> operations, DateScope scope) {
        return sumByDateScope(operations, scope).entrySet().stream()
                .map(e -> new DateScopedSummary(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

    public List<DateScopedProfit> calculateProfit(List<Operation> incomes, List<Operation> expenses, DateScope scope) {
        var groupedExpenses = sumByDateScope(expenses, scope).entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> -entry.getValue()));
        return Stream.of(sumByDateScope(incomes, scope), groupedExpenses)
                .map(Map::entrySet)
                .flatMap(Set::stream)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, Double::sum))
                .entrySet().stream()
                .map(e -> new DateScopedProfit(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

    private static Map<LocalDate, Double> sumByDateScope(List<Operation> operations, DateScope scope) {
        return operations.stream()
                .filter(o -> o.getDate() != null)
                .collect(Collectors.groupingBy(
                        operation -> getScopedDate(operation.getDate(), scope),
                        Collectors.summingDouble(Operation::getAmount))
                );
    }

    private static LocalDate getScopedDate(LocalDate date, DateScope scope) {
        return switch (scope) {
            case MONTH_BY_DAYS -> date;
            case YEAR_BY_MONTHS -> date.withDayOfMonth(1);
        };
    }
}
