package edu.njmsd.stonksmonkey.boundaries.adapters;

import edu.njmsd.stonksmonkey.boundaries.mappers.ReversibleMapper;
import edu.njmsd.stonksmonkey.data.entities.ExpenseEntity;
import edu.njmsd.stonksmonkey.data.repositories.ExpenseRepository;
import edu.njmsd.stonksmonkey.domain.models.Operation;
import edu.njmsd.stonksmonkey.domain.repositories.OperationRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ExpenseRepositoryAdapter extends CrudRepositoryAdapter<Operation, ExpenseEntity, ExpenseRepository> implements OperationRepository {

    public ExpenseRepositoryAdapter(ExpenseRepository repository, ReversibleMapper<ExpenseEntity, Operation> mapper) {
        super(repository, mapper);
    }

    @Override
    public List<Operation> getAllBetween(LocalDate from, LocalDate to) {
        return repository.findByDateBetween(from, to).stream().map(mapper::map).collect(Collectors.toList());
    }
}
