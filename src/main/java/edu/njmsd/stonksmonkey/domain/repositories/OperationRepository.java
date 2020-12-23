package edu.njmsd.stonksmonkey.domain.repositories;

import edu.njmsd.stonksmonkey.domain.models.Operation;

import java.time.LocalDate;
import java.util.List;

public interface OperationRepository extends CrudRepository<Operation> {

    List<Operation> getAllBetween(LocalDate from, LocalDate to, long userId);
}
