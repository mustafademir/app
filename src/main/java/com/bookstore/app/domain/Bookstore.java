package com.bookstore.app.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "bookstore")
public class Bookstore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookstore_id;

    @Column
    private String name;

    @Column
    private String city;

    @ManyToMany(cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
    @JoinTable(name = "store_book_association",joinColumns = { @JoinColumn(name = "bookstore_ass_id") },
            inverseJoinColumns = { @JoinColumn(name = "book_ass_id") })
    List<Book> books = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getBookstore_id() {
        return bookstore_id;
    }

    public void setBookstore_id(Long bookstore_id) {
        this.bookstore_id = bookstore_id;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
