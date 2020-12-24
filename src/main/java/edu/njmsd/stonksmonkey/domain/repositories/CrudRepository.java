package edu.njmsd.stonksmonkey.domain.repositories;

import java.util.List;

public interface CrudRepository<T> {

    T findById(long id, long userId);

    List<T> getAll(long userId);

    T save(T entity);

    void delete(long id);
}
