package edu.njmsd.stonksmonkey.data.repositories;

import edu.njmsd.stonksmonkey.data.entities.IncomeCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeCategoryRepository extends JpaRepository<IncomeCategoryEntity, Long> {
}
