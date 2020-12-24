package edu.njmsd.stonksmonkey.data.repositories;

import edu.njmsd.stonksmonkey.data.entities.IncomeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IncomeRepository extends JpaRepository<IncomeEntity, Long>, OwnedEntityRepository<IncomeEntity> {

    Optional<IncomeEntity> findByIdAndUserId(long id, long userId);

    List<IncomeEntity> findByUserId(long userId);

    List<IncomeEntity> findByDateBetweenAndUserId(LocalDate from, LocalDate to, long userId);
}
