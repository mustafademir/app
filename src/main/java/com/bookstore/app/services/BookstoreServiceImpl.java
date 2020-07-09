package com.bookstore.app.services;

import com.bookstore.app.dao.BookDaoJpa;
import com.bookstore.app.dao.BookstoreDaoJpa;
import com.bookstore.app.domain.Book;
import com.bookstore.app.domain.Bookstore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookstoreServiceImpl implements IBookstoreService {
    @Autowired
    private BookstoreDaoJpa bookstoreDaoJpa;

    public List<Bookstore> findAll() {
        return bookstoreDaoJpa.findAll();
    }

    public Bookstore createBookstore(Bookstore bookstore) {
        return bookstoreDaoJpa.save(bookstore);
    }

    public List<Book> getBookList(Long bookstoreId) {
        return bookstoreDaoJpa.findById(bookstoreId).get().getBooks();
    }
}
