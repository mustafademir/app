package com.bookstore.app.dtos;

import com.bookstore.app.domain.Book;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CategoryDto {

    private Long category_id;

    @JsonProperty("name")
    private String name;

    private List<Book> books;

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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
