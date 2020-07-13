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

    @Autowired
    private BookDaoJpa bookDaoJpa;

    public List<Bookstore> findAll() {
        return bookstoreDaoJpa.findAll();
    }

    public Bookstore createBookstore(Bookstore bookstore) {
        return bookstoreDaoJpa.save(bookstore);
    }

    public List<Book> getBookList(Long bookstoreId) {
        return bookstoreDaoJpa.findById(bookstoreId).get().getBooks();
    }

    public Bookstore addBook(Long bookId, Long bookstoreId) {
        Book book = bookDaoJpa.findById(bookId).get();
        Bookstore bookstore = bookstoreDaoJpa.findById(bookstoreId).get();
        bookstore.getBooks().add(book);
        return bookstoreDaoJpa.save(bookstore);
    }

    public Bookstore removeBook(Long bookId, Long bookstoreId) {
        Book book = bookDaoJpa.findById(bookId).get();
        Bookstore bookstore = bookstoreDaoJpa.findById(bookstoreId).get();
        bookstore.getBooks().remove(book);
        return bookstoreDaoJpa.save(bookstore);
    }
}
