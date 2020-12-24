package edu.njmsd.stonksmonkey.domain.validators;

import edu.njmsd.stonksmonkey.domain.exceptions.ValidationException;

public interface Validator<T> {

    void validate(T model) throws ValidationException;
}
