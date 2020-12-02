package edu.njmsd.stonksmonkey.domain.exceptions;

public class ModelNotFoundException extends RuntimeException {

    public ModelNotFoundException(long identifier) {
        super("Model with identifier " + identifier + " not found");
    }
}
