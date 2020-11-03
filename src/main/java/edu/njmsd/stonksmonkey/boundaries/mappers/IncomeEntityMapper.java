package edu.njmsd.stonksmonkey.boundaries.mappers;

import edu.njmsd.stonksmonkey.data.entities.IncomeCategoryEntity;
import edu.njmsd.stonksmonkey.data.entities.IncomeEntity;
import edu.njmsd.stonksmonkey.domain.models.Operation;
import edu.njmsd.stonksmonkey.domain.models.OperationCategory;
import org.springframework.stereotype.Component;

@Component
public class IncomeEntityMapper implements ModelMapper<Operation, IncomeEntity> {

    private final ModelMapper<OperationCategory, IncomeCategoryEntity> categoryMapper;

    public IncomeEntityMapper(ModelMapper<OperationCategory, IncomeCategoryEntity> categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    @Override
    public IncomeEntity mapFromModel(Operation model) {
        return new IncomeEntity(
                model.getId(),
                model.getUserId(),
                categoryMapper.mapFromModel(model.getCategory()),
                model.getAmount(),
                model.getDate()
        );
    }

    @Override
    public Operation mapToModel(IncomeEntity from) {
        return new Operation(
                from.getId(),
                from.getUserId(),
                categoryMapper.mapToModel(from.getCategory()),
                from.getAmount(),
                from.getDate()
        );
    }
}
