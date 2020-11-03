package edu.njmsd.stonksmonkey.boundaries.adapters;

import edu.njmsd.stonksmonkey.boundaries.mappers.ModelMapper;
import edu.njmsd.stonksmonkey.domain.repositories.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Collectors;

public class CrudRepositoryAdapter<M, E, R extends JpaRepository<E, Long>> implements CrudRepository<M> {

    private final R repository;
    private final ModelMapper<M, E> mapper;

    public CrudRepositoryAdapter(R repository, ModelMapper<M, E> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public M findById(long id) {
        return mapper.mapToModel(repository.findById(id).orElse(null));
    }

    @Override
    public List<M> getAll() {
        return repository.findAll().stream().map(mapper::mapToModel).collect(Collectors.toList());
    }

    @Override
    public M save(M entity) {
        return mapper.mapToModel(repository.save(mapper.mapFromModel(entity)));
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}
