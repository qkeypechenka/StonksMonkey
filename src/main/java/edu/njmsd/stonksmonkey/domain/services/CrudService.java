package edu.njmsd.stonksmonkey.domain.services;

import edu.njmsd.stonksmonkey.domain.exceptions.ModelNotFoundException;
import edu.njmsd.stonksmonkey.domain.repositories.CrudRepository;
import edu.njmsd.stonksmonkey.domain.validators.Validator;

import java.util.List;

public class CrudService<T> {

    private final CrudRepository<T> repository;
    private final Validator<T> validator;

    public CrudService(CrudRepository<T> repository, Validator<T> validator) {
        this.repository = repository;
        this.validator = validator;
    }

    public List<T> get() {
        return repository.getAll();
    }

    public T create(T model) {
        validator.validate(model);
        return repository.save(model);
    }

    public T update(T model) {
        validator.validate(model);
        return repository.save(model);
    }

    public void delete(long id) {
        if (repository.findById(id) == null)
            throw new ModelNotFoundException(id);
        repository.delete(id);
    }
}
