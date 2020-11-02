package edu.njmsd.stonksmonkey.data.repositories;

import edu.njmsd.stonksmonkey.data.entities.ExpenseCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseCategoryRepository extends JpaRepository<ExpenseCategoryEntity, Long> {
}
