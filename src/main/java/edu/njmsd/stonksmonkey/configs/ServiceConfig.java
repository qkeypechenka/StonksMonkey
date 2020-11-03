package edu.njmsd.stonksmonkey.configs;

import edu.njmsd.stonksmonkey.boundaries.adapters.CrudRepositoryAdapter;
import edu.njmsd.stonksmonkey.boundaries.mappers.ModelMapper;
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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public CrudService<OperationCategory> incomeCategoryCrudService(CrudRepository<OperationCategory> incomeCategoryCrudRepository) {
        return new CrudService<>(incomeCategoryCrudRepository);
    }

    @Bean
    public CrudRepository<OperationCategory> incomeCategoryCrudRepository(
            IncomeCategoryRepository repository,
            ModelMapper<OperationCategory, IncomeCategoryEntity> mapper) {
        return new CrudRepositoryAdapter<>(repository, mapper);
    }

    @Bean
    public CrudService<OperationCategory> expenseCategoryCrudService(CrudRepository<OperationCategory> expenseCategoryCrudRepository) {
        return new CrudService<>(expenseCategoryCrudRepository);
    }

    @Bean
    public CrudRepository<OperationCategory> expenseCategoryCrudRepository(
            ExpenseCategoryRepository repository,
            ModelMapper<OperationCategory, ExpenseCategoryEntity> mapper) {
        return new CrudRepositoryAdapter<>(repository, mapper);
    }

    @Bean
    public CrudService<Operation> expenseCrudService(CrudRepository<Operation> expenseCrudRepository) {
        return new CrudService<>(expenseCrudRepository);
    }

    @Bean
    public CrudRepository<Operation> expenseCrudRepository(
            ExpenseRepository repository,
            ModelMapper<Operation, ExpenseEntity> mapper) {
        return new CrudRepositoryAdapter<>(repository, mapper);
    }

    @Bean
    public CrudService<Operation> incomeCrudService(CrudRepository<Operation> incomeCrudRepository) {
        return new CrudService<>(incomeCrudRepository);
    }

    @Bean
    public CrudRepository<Operation> incomeCrudRepository(
            IncomeRepository repository,
            ModelMapper<Operation, IncomeEntity> mapper) {
        return new CrudRepositoryAdapter<>(repository, mapper);
    }
}
