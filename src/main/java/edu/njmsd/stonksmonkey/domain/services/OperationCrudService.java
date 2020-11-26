package edu.njmsd.stonksmonkey.domain.services;

import edu.njmsd.stonksmonkey.domain.models.Operation;
import edu.njmsd.stonksmonkey.domain.models.OperationCategory;
import edu.njmsd.stonksmonkey.domain.repositories.CrudRepository;

public class OperationCrudService extends CrudService<Operation> {

    private final CrudRepository<OperationCategory> categoryRepository;

    public OperationCrudService(
            CrudRepository<Operation> operationRepository,
            CrudRepository<OperationCategory> categoryRepository) {
        super(operationRepository);
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Operation create(Operation model) {
        model.setCategory(categoryRepository.findById(model.getCategory().getId()));
        return super.create(model);
    }

    @Override
    public Operation update(Operation model) {
        model.setCategory(categoryRepository.findById(model.getCategory().getId()));
        return super.update(model);
    }
}
