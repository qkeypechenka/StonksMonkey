package edu.njmsd.stonksmonkey.api.dto;

import edu.njmsd.stonksmonkey.domain.models.Identifiable;

public class OperationCategoryDto implements Identifiable {

    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
