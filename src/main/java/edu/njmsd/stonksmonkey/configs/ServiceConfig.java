package edu.njmsd.stonksmonkey.configs;

import edu.njmsd.stonksmonkey.boundaries.adapters.CrudRepositoryAdapter;
import edu.njmsd.stonksmonkey.boundaries.mappers.ReversibleMapper;
import edu.njmsd.stonksmonkey.data.entities.ExpenseCategoryEntity;
import edu.njmsd.stonksmonkey.data.entities.ExpenseEntity;
import edu.njmsd.stonksmonkey.data.entities.IncomeCategoryEntity;
import edu.njmsd.stonksmonkey.data.entities.IncomeEntity;
import edu.njmsd.stonksmonkey.data.repositories.ExpenseCategoryRepository;
import edu.njmsd.stonksmonkey.data.repositories.ExpenseRepository;
import edu.njmsd.stonksmonkey.data.repositories.IncomeCategoryRepository;
import edu.njmsd.stonksmonkey.data.repositories.IncomeRepository;
import edu.njmsd.stonksmonkey.domain.models.Operation;
import edu.njmsd.stonksmonkey.domain.models.OperationCategory;
import edu.njmsd.stonksmonkey.domain.repositories.CrudRepository;
import edu.njmsd.stonksmonkey.domain.services.CrudService;
import edu.njmsd.stonksmonkey.domain.services.OperationCrudService;
import edu.njmsd.stonksmonkey.domain.validators.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public CrudService<OperationCategory> incomeCategoryCrudService(
            CrudRepository<OperationCategory> incomeCategoryCrudRepository,
            Validator<OperationCategory> operationCategoryValidator) {
        return new CrudService<>(incomeCategoryCrudRepository, operationCategoryValidator);
    }

    @Bean
    public CrudRepository<OperationCategory> incomeCategoryCrudRepository(
            IncomeCategoryRepository repository,
            ReversibleMapper<IncomeCategoryEntity, OperationCategory> incomeCategoryMapper) {
        return new CrudRepositoryAdapter<>(repository, incomeCategoryMapper);
    }

    @Bean
    public CrudService<OperationCategory> expenseCategoryCrudService(
            CrudRepository<OperationCategory> expenseCategoryCrudRepository,
            Validator<OperationCategory> operationCategoryValidator) {
        return new CrudService<>(expenseCategoryCrudRepository, operationCategoryValidator);
    }

    @Bean
    public CrudRepository<OperationCategory> expenseCategoryCrudRepository(
            ExpenseCategoryRepository repository,
            ReversibleMapper<ExpenseCategoryEntity, OperationCategory> expenseCategoryMapper) {
        return new CrudRepositoryAdapter<>(repository, expenseCategoryMapper);
    }

    @Bean
    public CrudService<Operation> expenseCrudService(
            CrudRepository<Operation> expenseCrudRepository,
            CrudRepository<OperationCategory> expenseCategoryCrudRepository,
            Validator<Operation> operationValidator) {
        return new OperationCrudService(expenseCrudRepository, expenseCategoryCrudRepository, operationValidator);
    }

    @Bean
    public CrudRepository<Operation> expenseCrudRepository(
            ExpenseRepository repository,
            ReversibleMapper<ExpenseEntity, Operation> expenseMapper) {
        return new CrudRepositoryAdapter<>(repository, expenseMapper);
    }

    @Bean
    public CrudService<Operation> incomeCrudService(
            CrudRepository<Operation> incomeCrudRepository,
            CrudRepository<OperationCategory> incomeCategoryCrudRepository,
            Validator<Operation> operationValidator) {
        return new OperationCrudService(incomeCrudRepository, incomeCategoryCrudRepository, operationValidator);
    }

    @Bean
    public CrudRepository<Operation> incomeCrudRepository(
            IncomeRepository repository,
            ReversibleMapper<IncomeEntity, Operation> incomeMapper) {
        return new CrudRepositoryAdapter<>(repository, incomeMapper);
    }
}
