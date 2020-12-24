package edu.njmsd.stonksmonkey.domain.exceptions;

public class ModelNotFoundException extends Exception {

    public ModelNotFoundException(long identifier) {
        super("Model with identifier: " + identifier + ", not found");
    }
}
