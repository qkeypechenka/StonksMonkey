package edu.njmsd.stonksmonkey.boundaries.mappers;

import edu.njmsd.stonksmonkey.data.entities.IncomeCategoryEntity;
import edu.njmsd.stonksmonkey.domain.models.OperationCategory;
import org.springframework.stereotype.Component;

@Component
public class IncomeCategoryEntityMapper implements ModelMapper<OperationCategory, IncomeCategoryEntity> {

    @Override
    public OperationCategory mapToModel(IncomeCategoryEntity from) {
        return from;
    }

    @Override
    public IncomeCategoryEntity mapFromModel(OperationCategory model) {
        return new IncomeCategoryEntity(model.getId(), model.getUserId(), model.getName());
    }
}
