package edu.njmsd.stonksmonkey.boundaries.mappers;

public interface ModelMapper<M, T> {
    M mapToModel(T from);

    T mapFromModel(M model);
}
