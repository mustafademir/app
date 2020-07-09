package com.bookstore.app.services;

import com.bookstore.app.domain.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    Book createBook(Book book);

    Book changeCategory(Long cId, Long bookId);
}
