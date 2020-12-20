package edu.njmsd.stonksmonkey.domain.services;

import edu.njmsd.stonksmonkey.domain.models.*;
import edu.njmsd.stonksmonkey.domain.repositories.OperationRepository;
import edu.njmsd.stonksmonkey.domain.stats.OperationCategoryStatisticsCalculator;
import edu.njmsd.stonksmonkey.domain.stats.SummaryStatisticsCalculator;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StatisticsService {

    private final OperationCategoryStatisticsCalculator categoryStatisticsCalculator;
    private final SummaryStatisticsCalculator summaryStatisticsCalculator;
    private final OperationRepository incomesRepository;
    private final OperationRepository expenseRepository;

    StatisticsService(
            OperationCategoryStatisticsCalculator categoryStatisticsCalculator,
            SummaryStatisticsCalculator summaryStatisticsCalculator,
            OperationRepository incomeCrudRepository,
            OperationRepository expenseCrudRepository) {
        this.categoryStatisticsCalculator = categoryStatisticsCalculator;
        this.summaryStatisticsCalculator = summaryStatisticsCalculator;
        this.incomesRepository = incomeCrudRepository;
        this.expenseRepository = expenseCrudRepository;
    }

    public List<OperationCategorySummary> sumIncomesByCategory(StatisticParams params) {
        return categoryStatisticsCalculator.sumByCategory(getOperations(incomesRepository, params));
    }

    public List<OperationCategorySummary> sumExpensesByCategory(StatisticParams params) {
        return categoryStatisticsCalculator.sumByCategory(getOperations(expenseRepository, params));
    }

    public List<OperationCategoryPercentage> getIncomesCategoryPercentage(StatisticParams params) {
        return categoryStatisticsCalculator.getPercentageByCategory(getOperations(incomesRepository, params));
    }

    public List<OperationCategoryPercentage> getExpensesCategoryPercentage(StatisticParams params) {
        return categoryStatisticsCalculator.getPercentageByCategory(getOperations(expenseRepository, params));
    }

    public List<DateScopedSummary> sumIncomes(DateScopedStatisticParams params) {
        return summaryStatisticsCalculator.sumAmounts(getOperations(incomesRepository, params), params.scope);
    }

    public List<DateScopedSummary> sumExpenses(DateScopedStatisticParams params) {
        return summaryStatisticsCalculator.sumAmounts(getOperations(expenseRepository, params), params.scope);
    }

    public List<DateScopedProfit> getProfit(DateScopedStatisticParams params) {
        var incomes = getOperations(incomesRepository, params);
        var expenses = getOperations(expenseRepository, params);
        return summaryStatisticsCalculator.calculateProfit(incomes, expenses, params.scope);
    }

    private static List<Operation> getOperations(OperationRepository repository, StatisticParams params) {
        return params.from == null || params.to == null
                ? repository.getAll()
                : repository.getAllBetween(params.from, params.to);
    }

    public static class StatisticParams {

        private final LocalDate from;
        private final LocalDate to;

        public StatisticParams(LocalDate from, LocalDate to) {
            this.from = from;
            this.to = to;
        }
    }

    public static class DateScopedStatisticParams extends StatisticParams {

        private final DateScope scope;

        public DateScopedStatisticParams(LocalDate from, LocalDate to, DateScope scope) {
            super(from, to);
            this.scope = scope;
        }
    }
}
