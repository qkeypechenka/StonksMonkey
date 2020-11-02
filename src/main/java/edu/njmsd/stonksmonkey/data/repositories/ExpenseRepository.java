package edu.njmsd.stonksmonkey.data.repositories;

import edu.njmsd.stonksmonkey.data.entities.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<ExpenseEntity, Long> {
}
