package com.bookstore.app.dtos;

import com.bookstore.app.domain.Bookstore;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BookDto {

    @JsonProperty("book_id")
    private Long book_id;

    @JsonProperty("name")
    private String name;

    private CategoryDto category;

    @JsonProperty("price")
    private Long price;

//    private List<BookstoreDto> bookstores;

    public Long getBook_id() {
        return book_id;
    }

    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    /*public List<BookstoreDto> getBookstores() {
        return bookstores;
    }

    public void setBookstores(List<BookstoreDto> bookstores) {
        this.bookstores = bookstores;
    }*/
}
