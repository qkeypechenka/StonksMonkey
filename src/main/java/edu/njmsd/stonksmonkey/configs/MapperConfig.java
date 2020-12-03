package edu.njmsd.stonksmonkey.configs;

import edu.njmsd.stonksmonkey.api.dto.*;
import edu.njmsd.stonksmonkey.boundaries.mappers.AutoMapper;
import edu.njmsd.stonksmonkey.boundaries.mappers.Mapper;
import edu.njmsd.stonksmonkey.boundaries.mappers.ReversibleMapper;
import edu.njmsd.stonksmonkey.data.entities.ExpenseCategoryEntity;
import edu.njmsd.stonksmonkey.data.entities.ExpenseEntity;
import edu.njmsd.stonksmonkey.data.entities.IncomeCategoryEntity;
import edu.njmsd.stonksmonkey.data.entities.IncomeEntity;
import edu.njmsd.stonksmonkey.domain.models.Operation;
import edu.njmsd.stonksmonkey.domain.models.OperationCategory;
import edu.njmsd.stonksmonkey.domain.models.OperationCategoryPercentage;
import edu.njmsd.stonksmonkey.domain.models.OperationCategorySummary;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public Mapper<OperationCategorySummary, OperationCategorySummaryDto> summaryMapper(ModelMapper modelMapper) {
        return new AutoMapper<>(modelMapper, OperationCategorySummary.class, OperationCategorySummaryDto.class);
    }

    @Bean
    public Mapper<OperationCategoryPercentage, OperationCategoryPercentageDto> percentageMapper(ModelMapper modelMapper) {
        return new AutoMapper<>(modelMapper, OperationCategoryPercentage.class, OperationCategoryPercentageDto.class);
    }

    @Bean
    public Mapper<OperationCategory, OperationCategoryDto> categoryDtoMapper(ModelMapper modelMapper) {
        return new AutoMapper<>(modelMapper, OperationCategory.class, OperationCategoryDto.class);
    }

    @Bean
    public Mapper<OperationCategoryModificationDto, OperationCategory> categoryMapper(ModelMapper modelMapper) {
        return new AutoMapper<>(modelMapper, OperationCategoryModificationDto.class, OperationCategory.class);
    }

    @Bean
    public Mapper<Operation, OperationDto> operationDtoMapper(ModelMapper modelMapper) {
        return new AutoMapper<>(modelMapper, Operation.class, OperationDto.class);
    }

    @Bean
    public Mapper<OperationModificationDto, Operation> operationMapper(ModelMapper modelMapper) {
        return new AutoMapper<>(modelMapper, OperationModificationDto.class, Operation.class);
    }

    @Bean
    public ReversibleMapper<ExpenseCategoryEntity, OperationCategory> expenseCategoryMapper(ModelMapper modelMapper) {
        return new AutoMapper<>(modelMapper, ExpenseCategoryEntity.class, OperationCategory.class);
    }

    @Bean
    public ReversibleMapper<IncomeCategoryEntity, OperationCategory> incomeCategoryMapper(ModelMapper modelMapper) {
        return new AutoMapper<>(modelMapper, IncomeCategoryEntity.class, OperationCategory.class);
    }

    @Bean
    public ReversibleMapper<ExpenseEntity, Operation> expenseMapper(ModelMapper modelMapper) {
        return new AutoMapper<>(modelMapper, ExpenseEntity.class, Operation.class);
    }

    @Bean
    public ReversibleMapper<IncomeEntity, Operation> incomeMapper(ModelMapper modelMapper) {
        return new AutoMapper<>(modelMapper, IncomeEntity.class, Operation.class);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
