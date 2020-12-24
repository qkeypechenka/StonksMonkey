package edu.njmsd.stonksmonkey.data.repositories;

import java.util.List;
import java.util.Optional;

public interface OwnedEntityRepository<E> {

    Optional<E> findByIdAndUserId(long id, long userId);

    List<E> findByUserId(long userId);
}
