package edu.njmsd.stonksmonkey.api.controllers.stats;

import edu.njmsd.stonksmonkey.api.dto.ListResponse;
import edu.njmsd.stonksmonkey.domain.models.OperationCategoryPercentage;
import edu.njmsd.stonksmonkey.domain.models.OperationCategorySummary;
import edu.njmsd.stonksmonkey.domain.services.StatisticsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
public class StatisticsController {
    private final StatisticsService service;

    StatisticsController(StatisticsService service) {
        this.service = service;
    }

    @GetMapping("/incomes")
    public ListResponse<OperationCategorySummary> sumIncomesByCategory() {
        return new ListResponse<>(service.sumIncomesByCategory());
    }

    @GetMapping("/expenses")
    public ListResponse<OperationCategorySummary> sumExpensesByCategory() {
        return new ListResponse<>(service.sumExpensesByCategory());
    }

    @GetMapping("/incomes/percentage")
    public ListResponse<OperationCategoryPercentage> getIncomesCategoryPercentage() {
        return new ListResponse<>(service.getIncomesCategoryPercentage());
    }

    @GetMapping("/expenses/percentage")
    public ListResponse<OperationCategoryPercentage> getExpensesCategoryPercentage() {
        return new ListResponse<>(service.getExpensesCategoryPercentage());
    }

}
