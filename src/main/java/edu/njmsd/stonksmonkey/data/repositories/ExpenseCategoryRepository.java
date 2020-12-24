package edu.njmsd.stonksmonkey.data.repositories;

import edu.njmsd.stonksmonkey.data.entities.ExpenseCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ExpenseCategoryRepository extends JpaRepository<ExpenseCategoryEntity, Long>,
        OwnedEntityRepository<ExpenseCategoryEntity> {

    Optional<ExpenseCategoryEntity> findByIdAndUserId(long id, long userId);

    List<ExpenseCategoryEntity> findByUserId(long userId);
}
