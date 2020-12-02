package edu.njmsd.stonksmonkey.boundaries.adapters;

import edu.njmsd.stonksmonkey.boundaries.mappers.ReversibleMapper;
import edu.njmsd.stonksmonkey.domain.repositories.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Collectors;

public class CrudRepositoryAdapter<M, E, R extends JpaRepository<E, Long>> implements CrudRepository<M> {

    private final R repository;
    private final ReversibleMapper<E, M> mapper;

    public CrudRepositoryAdapter(R repository, ReversibleMapper<E, M> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public M findById(long id) {
        return mapper.map(repository.findById(id).orElse(null));
    }

    @Override
    public List<M> getAll() {
        return repository.findAll().stream().map(mapper::map).collect(Collectors.toList());
    }

    @Override
    public M save(M model) {
        return mapper.map(repository.save(mapper.mapBackFrom(model)));
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}
