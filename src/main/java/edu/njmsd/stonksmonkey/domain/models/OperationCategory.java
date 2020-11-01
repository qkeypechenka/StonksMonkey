package edu.njmsd.stonksmonkey.domain.models;

public class OperationCategory {

    private final long id;
    private final long userId;
    private final String name;

    public OperationCategory(long id, long userId, String name) {
        this.id = id;
        this.userId = userId;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }
}
