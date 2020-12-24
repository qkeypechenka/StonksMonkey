package edu.njmsd.stonksmonkey.boundaries.mappers;

public interface ReversibleMapper<S, T> extends Mapper<S, T> {
    S mapBackFrom(T target);
}
