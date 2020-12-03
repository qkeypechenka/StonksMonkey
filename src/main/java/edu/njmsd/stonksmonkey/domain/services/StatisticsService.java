package edu.njmsd.stonksmonkey.domain.services;

import edu.njmsd.stonksmonkey.domain.models.Operation;
import edu.njmsd.stonksmonkey.domain.models.OperationCategoryPercentage;
import edu.njmsd.stonksmonkey.domain.models.OperationCategorySummary;
import edu.njmsd.stonksmonkey.domain.repositories.OperationRepository;
import edu.njmsd.stonksmonkey.domain.stats.OperationCategoryStatisticsCalculator;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StatisticsService {

    private final OperationCategoryStatisticsCalculator calculator;
    private final OperationRepository incomesRepository;
    private final OperationRepository expenseRepository;

    StatisticsService(
            OperationCategoryStatisticsCalculator calculator,
            OperationRepository incomeCrudRepository,
            OperationRepository expenseCrudRepository) {
        this.calculator = calculator;
        this.incomesRepository = incomeCrudRepository;
        this.expenseRepository = expenseCrudRepository;
    }

    public List<OperationCategorySummary> sumIncomesByCategory(StatisticParams params) {
        return this.calculator.sumByCategory(getOperations(incomesRepository, params));
    }

    public List<OperationCategorySummary> sumExpensesByCategory(StatisticParams params) {
        return this.calculator.sumByCategory(getOperations(expenseRepository, params));
    }

    public List<OperationCategoryPercentage> getIncomesCategoryPercentage(StatisticParams params) {
        return this.calculator.getPercentageByCategory(getOperations(incomesRepository, params));
    }

    public List<OperationCategoryPercentage> getExpensesCategoryPercentage(StatisticParams params) {
        return this.calculator.getPercentageByCategory(getOperations(expenseRepository, params));
    }

    private static List<Operation> getOperations(OperationRepository repository, StatisticParams params) {
        return params.getFrom() == null || params.getTo() == null
                ? repository.getAll()
                : repository.getAllBetween(params.getFrom(), params.getTo());
    }

    public static class StatisticParams {

        private final LocalDate from;
        private final LocalDate to;

        public StatisticParams(LocalDate from, LocalDate to) {
            this.from = from;
            this.to = to;
        }

        LocalDate getFrom() {
            return from;
        }

        LocalDate getTo() {
            return to;
        }
    }
}
