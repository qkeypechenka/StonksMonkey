package edu.njmsd.stonksmonkey.domain.services;

import edu.njmsd.stonksmonkey.domain.models.Operation;
import edu.njmsd.stonksmonkey.domain.models.OperationCategory;
import edu.njmsd.stonksmonkey.domain.repositories.CrudRepository;
import edu.njmsd.stonksmonkey.domain.validators.Validator;

public class OperationCrudService extends CrudService<Operation> {

    private final CrudRepository<OperationCategory> categoryRepository;

    public OperationCrudService(
            CrudRepository<Operation> operationRepository,
            CrudRepository<OperationCategory> categoryRepository,
            Validator<Operation> validator) {
        super(operationRepository, validator);
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Operation create(Operation model) {
        return super.create(resolveCategory(model));
    }

    @Override
    public Operation update(Operation model) {
        return super.update(resolveCategory(model));
    }

    private Operation resolveCategory(Operation operation) {
        if (operation.getCategory() != null)
            operation.setCategory(categoryRepository.findById(operation.getCategory().getId()));
        return operation;
    }
}
