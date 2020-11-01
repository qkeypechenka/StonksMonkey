package edu.njmsd.stonksmonkey.domain.repositories;

import java.util.List;

public interface CrudRepository<T> {

    T findById(long id);

    List<T> getAll();

    T save(T entity);

    void delete(long id);
}
