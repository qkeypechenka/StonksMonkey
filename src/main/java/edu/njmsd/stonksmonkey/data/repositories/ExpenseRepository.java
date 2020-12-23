package edu.njmsd.stonksmonkey.data.repositories;

import edu.njmsd.stonksmonkey.data.entities.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ExpenseRepository extends JpaRepository<ExpenseEntity, Long>,
        OwnedEntityRepository<ExpenseEntity> {

    Optional<ExpenseEntity> findByIdAndUserId(long id, long userId);

    List<ExpenseEntity> findByUserId(long userId);

    List<ExpenseEntity> findByDateBetweenAndUserId(LocalDate from, LocalDate to, long userId);
}
