package com.bookstore.app.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryDto {

    private Long category_id;

    @JsonProperty("name")
    private String name;

    public Long getId() {
        return category_id;
    }

    public void setId(Long id) {
        this.category_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
