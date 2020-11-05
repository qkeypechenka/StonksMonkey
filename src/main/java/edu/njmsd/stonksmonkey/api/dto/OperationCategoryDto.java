package edu.njmsd.stonksmonkey.api.dto;

public class OperationCategoryDto {

    private final long id;
    private final String name;

    public OperationCategoryDto(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
