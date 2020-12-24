package edu.njmsd.stonksmonkey.api.dto;

import java.util.List;

public class ListResponse<T> {

    private final List<T> items;

    public ListResponse(List<T> items) {
        this.items = items;
    }

    public List<T> getItems() {
        return items;
    }
}
