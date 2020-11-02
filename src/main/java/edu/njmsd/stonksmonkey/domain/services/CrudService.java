package edu.njmsd.stonksmonkey.domain.services;

import edu.njmsd.stonksmonkey.domain.repositories.CrudRepository;

import java.util.List;

public class CrudService<T> {

    private final CrudRepository<T> repository;

    public CrudService(CrudRepository<T> repository) {
        this.repository = repository;
    }

    public List<T> get() {
        return repository.getAll();
    }

    public T create(T model) {
        return repository.save(model);
    }

    public T update(T model) {
        return repository.save(model);
    }

    public void delete(long id) {
        repository.delete(id);
    }
}
