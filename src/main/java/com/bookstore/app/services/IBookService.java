package com.bookstore.app.services;

import com.bookstore.app.domain.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    Book createBook(Book book);

    Integer changeCategory(Long cId, Long bookId);
}
