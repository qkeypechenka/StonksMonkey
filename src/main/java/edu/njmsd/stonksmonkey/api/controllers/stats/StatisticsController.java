package edu.njmsd.stonksmonkey.api.controllers.stats;

import edu.njmsd.stonksmonkey.api.dto.DateScopeDto;
import edu.njmsd.stonksmonkey.api.dto.ListResponse;
import edu.njmsd.stonksmonkey.api.dto.OperationCategoryPercentageDto;
import edu.njmsd.stonksmonkey.api.dto.OperationCategorySummaryDto;
import edu.njmsd.stonksmonkey.boundaries.mappers.Mapper;
import edu.njmsd.stonksmonkey.domain.models.*;
import edu.njmsd.stonksmonkey.domain.services.StatisticsService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("/stats")
public class StatisticsController {

    private final StatisticsService service;
    private final Mapper<OperationCategorySummary, OperationCategorySummaryDto> summaryMapper;
    private final Mapper<OperationCategoryPercentage, OperationCategoryPercentageDto> percentageMapper;
    private final Mapper<DateScopeDto, DateScope> dateScopeMapper;

    StatisticsController(
            StatisticsService service,
            Mapper<OperationCategorySummary, OperationCategorySummaryDto> summaryMapper,
            Mapper<OperationCategoryPercentage, OperationCategoryPercentageDto> percentageMapper,
            Mapper<DateScopeDto, DateScope> dateScopeMapper) {
        this.service = service;
        this.summaryMapper = summaryMapper;
        this.percentageMapper = percentageMapper;
        this.dateScopeMapper = dateScopeMapper;
    }

    @GetMapping("/profit")
    public ListResponse<DateScopedProfit> getProfit(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to,
            @RequestParam(defaultValue = DateScopeDto.defaultValue) DateScopeDto scope
    ) {
        var params = new StatisticsService.DateScopedStatisticParams(from, to, dateScopeMapper.map(scope));
        var stats = service.getProfit(params);
        return new ListResponse<>(stats);
    }

    @GetMapping("/incomes")
    public ListResponse<OperationCategorySummaryDto> sumIncomesByCategory(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to
    ) {
        var stats = service.sumIncomesByCategory(new StatisticsService.StatisticParams(from, to));
        return new ListResponse<>(stats.stream().map(summaryMapper::map).collect(Collectors.toList()));
    }

    @GetMapping("/incomes/percentage")
    public ListResponse<OperationCategoryPercentageDto> getIncomesCategoryPercentage(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to
    ) {
        var stats = service.getIncomesCategoryPercentage(new StatisticsService.StatisticParams(from, to));
        return new ListResponse<>(stats.stream().map(percentageMapper::map).collect(Collectors.toList()));
    }

    @GetMapping("/summary/income")
    public ListResponse<DateScopedSummary> getIncomeSummary(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to,
            @RequestParam(defaultValue = DateScopeDto.defaultValue) DateScopeDto scope
    ) {
        var params = new StatisticsService.DateScopedStatisticParams(from, to, dateScopeMapper.map(scope));
        var stats = service.sumIncomes(params);
        return new ListResponse<>(stats);
    }

    @GetMapping("/expenses")
    public ListResponse<OperationCategorySummaryDto> sumExpensesByCategory(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to
    ) {
        var stats = service.sumExpensesByCategory(new StatisticsService.StatisticParams(from, to));
        return new ListResponse<>(stats.stream().map(summaryMapper::map).collect(Collectors.toList()));
    }

    @GetMapping("/expenses/percentage")
    public ListResponse<OperationCategoryPercentageDto> getExpensesCategoryPercentage(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to
    ) {
        var stats = service.getExpensesCategoryPercentage(new StatisticsService.StatisticParams(from, to));
        return new ListResponse<>(stats.stream().map(percentageMapper::map).collect(Collectors.toList()));
    }

    @GetMapping("/summary/expense")
    public ListResponse<DateScopedSummary> getExpenseSummary(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to,
            @RequestParam(defaultValue = DateScopeDto.defaultValue) DateScopeDto scope
    ) {
        var params = new StatisticsService.DateScopedStatisticParams(from, to, dateScopeMapper.map(scope));
        var stats = service.sumExpenses(params);
        return new ListResponse<>(stats);
    }
}
