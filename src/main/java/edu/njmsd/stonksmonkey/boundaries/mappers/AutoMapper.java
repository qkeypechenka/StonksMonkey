package edu.njmsd.stonksmonkey.boundaries.mappers;

import org.modelmapper.ModelMapper;

public class AutoMapper<S, T> implements ReversibleMapper<S, T> {

    private final ModelMapper modelMapper;
    private final Class<S> source;
    private final Class<T> target;

    public AutoMapper(ModelMapper modelMapper, Class<S> source, Class<T> target) {
        this.modelMapper = modelMapper;
        this.source = source;
        this.target = target;
    }

    @Override
    public T map(S source) {
        return modelMapper.map(source, target);
    }

    @Override
    public S mapBackFrom(T target) {
        return modelMapper.map(target, source);
    }
}
