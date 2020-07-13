package com.bookstore.app.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long book_id;

    @Column
    private String name;

    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name="category_id")
    @JsonIgnore
    private Category category;

    @ManyToMany(mappedBy = "books",fetch = FetchType.LAZY)
    private Set<Bookstore> bookstores = new HashSet<>();

    @Column
    private Long price;

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Set<Bookstore> getBookstores() {
        return bookstores;
    }

    public void setBookstores(Set<Bookstore> bookstores) {
        this.bookstores = bookstores;
    }
}
