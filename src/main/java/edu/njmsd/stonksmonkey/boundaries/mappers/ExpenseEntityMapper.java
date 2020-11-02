package edu.njmsd.stonksmonkey.boundaries.mappers;

import edu.njmsd.stonksmonkey.data.entities.ExpenseCategoryEntity;
import edu.njmsd.stonksmonkey.data.entities.ExpenseEntity;
import edu.njmsd.stonksmonkey.domain.models.Operation;
import edu.njmsd.stonksmonkey.domain.models.OperationCategory;
import org.springframework.stereotype.Component;

@Component
public class ExpenseEntityMapper implements ModelMapper<Operation, ExpenseEntity> {
    private final ModelMapper<OperationCategory, ExpenseCategoryEntity> categoryMapper;

    public ExpenseEntityMapper(ModelMapper<OperationCategory, ExpenseCategoryEntity> categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    @Override
    public ExpenseEntity mapFromModel(Operation model) {
        return new ExpenseEntity(
                model.getId(),
                model.getUserId(),
                categoryMapper.mapFromModel(model.getCategory()),
                model.getAmount(),
                model.getDate());
    }

    @Override
    public Operation mapToModel(ExpenseEntity from) {
        return new Operation(
                from.getId(),
                from.getUserId(),
                categoryMapper.mapToModel(from.getCategory()),
                from.getAmount(),
                from.getDate());
    }
}
