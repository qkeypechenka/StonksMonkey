package edu.njmsd.stonksmonkey.data.repositories;

import edu.njmsd.stonksmonkey.data.entities.IncomeCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IncomeCategoryRepository extends JpaRepository<IncomeCategoryEntity, Long>,
        OwnedEntityRepository<IncomeCategoryEntity> {

    Optional<IncomeCategoryEntity> findByIdAndUserId(long id, long userId);

    List<IncomeCategoryEntity> findByUserId(long userId);
}
