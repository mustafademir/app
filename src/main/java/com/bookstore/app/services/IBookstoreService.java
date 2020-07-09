package com.bookstore.app.services;

import com.bookstore.app.domain.Book;
import com.bookstore.app.domain.Bookstore;

import java.util.List;

public interface IBookstoreService {
    List<Bookstore> findAll();

    Bookstore createBookstore(Bookstore bookstore);

    List<Book> getBookList(Long bookstoreId);
}
