package edu.njmsd.stonksmonkey.domain.services;

import edu.njmsd.stonksmonkey.domain.models.Operation;
import edu.njmsd.stonksmonkey.domain.models.OperationCategoryPercentage;
import edu.njmsd.stonksmonkey.domain.models.OperationCategorySummary;
import edu.njmsd.stonksmonkey.domain.repositories.CrudRepository;
import edu.njmsd.stonksmonkey.domain.stats.OperationCategoryStatisticsCalculator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsService {
    private final OperationCategoryStatisticsCalculator calculator;
    private final CrudRepository<Operation> incomesRepository;
    private final CrudRepository<Operation> expenseRepository;

    StatisticsService(OperationCategoryStatisticsCalculator calculator,
                      CrudRepository<Operation> incomeCrudRepository,
                      CrudRepository<Operation> expenseCrudRepository) {
        this.calculator = calculator;
        this.incomesRepository = incomeCrudRepository;
        this.expenseRepository = expenseCrudRepository;
    }

    public List<OperationCategorySummary> sumIncomesByCategory() {
        return this.calculator.sumByCategory(incomesRepository.getAll());
    }

    public List<OperationCategorySummary> sumExpensesByCategory() {
        return this.calculator.sumByCategory(expenseRepository.getAll());
    }

    public List<OperationCategoryPercentage> getExpensesCategoryPercentage() {
        return this.calculator.getPercentageByCategory(expenseRepository.getAll());
    }

    public List<OperationCategoryPercentage> getIncomesCategoryPercentage() {
        return this.calculator.getPercentageByCategory(incomesRepository.getAll());
    }
}
