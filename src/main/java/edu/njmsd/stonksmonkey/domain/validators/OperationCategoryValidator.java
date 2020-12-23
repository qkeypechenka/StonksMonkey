package edu.njmsd.stonksmonkey.domain.validators;

import edu.njmsd.stonksmonkey.domain.exceptions.ValidationException;
import edu.njmsd.stonksmonkey.domain.models.OperationCategory;
import org.springframework.stereotype.Component;

@Component
public class OperationCategoryValidator implements Validator<OperationCategory> {

    @Override
    public void validate(OperationCategory model) throws ValidationException {
        validateName(model);
    }

    private static void validateName(OperationCategory category) throws ValidationException {
        if (category.getName() == null || category.getName().isBlank())
            throw new ValidationException("Operation category name cannot be empty");
    }
}
