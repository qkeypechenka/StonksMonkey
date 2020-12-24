package edu.njmsd.stonksmonkey.boundaries.adapters;

import edu.njmsd.stonksmonkey.boundaries.mappers.ReversibleMapper;
import edu.njmsd.stonksmonkey.data.entities.IncomeEntity;
import edu.njmsd.stonksmonkey.data.repositories.IncomeRepository;
import edu.njmsd.stonksmonkey.domain.models.Operation;
import edu.njmsd.stonksmonkey.domain.repositories.OperationRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class IncomeRepositoryAdapter extends CrudRepositoryAdapter<Operation, IncomeEntity, IncomeRepository> implements OperationRepository {

    public IncomeRepositoryAdapter(IncomeRepository repository, ReversibleMapper<IncomeEntity, Operation> mapper) {
        super(repository, mapper);
    }

    @Override
    public List<Operation> getAllBetween(LocalDate from, LocalDate to, long userId) {
        return repository.findByDateBetweenAndUserId(from, to, userId).stream()
                .map(mapper::map)
                .collect(Collectors.toList());
    }
}
