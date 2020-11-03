package edu.njmsd.stonksmonkey.boundaries.mappers;

import edu.njmsd.stonksmonkey.data.entities.ExpenseCategoryEntity;
import edu.njmsd.stonksmonkey.domain.models.OperationCategory;
import org.springframework.stereotype.Component;

@Component
public class ExpenseCategoryEntityMapper implements ModelMapper<OperationCategory, ExpenseCategoryEntity> {

    @Override
    public OperationCategory mapToModel(ExpenseCategoryEntity from) {
        return from;
    }

    @Override
    public ExpenseCategoryEntity mapFromModel(OperationCategory model) {
        return new ExpenseCategoryEntity(model.getId(), model.getUserId(), model.getName());
    }
}
