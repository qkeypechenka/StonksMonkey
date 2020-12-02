package edu.njmsd.stonksmonkey.domain.validators;

import edu.njmsd.stonksmonkey.domain.exceptions.ValidationException;
import edu.njmsd.stonksmonkey.domain.models.Operation;
import org.springframework.stereotype.Component;

@Component
public class OperationValidator implements Validator<Operation> {

    @Override
    public void validate(Operation model) throws ValidationException {
        validateAmount(model);
    }

    private static void validateAmount(Operation operation) throws ValidationException {
        if (operation.getAmount() <= 0)
            throw new ValidationException("The amount of operation must be positive");
    }
}
