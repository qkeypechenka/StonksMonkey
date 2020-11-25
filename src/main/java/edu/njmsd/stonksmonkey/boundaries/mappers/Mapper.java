package edu.njmsd.stonksmonkey.boundaries.mappers;

public interface Mapper<S, T> {
    T map(S source);
}
