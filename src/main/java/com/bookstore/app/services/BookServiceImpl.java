package com.bookstore.app.services;

import com.bookstore.app.dao.BookDaoJpa;
import com.bookstore.app.dao.CategoryDaoJpa;
import com.bookstore.app.domain.Book;
import com.bookstore.app.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    private BookDaoJpa bookDaoJpa;

    @Autowired
    CategoryDaoJpa categoryDaoJpa;

    public List<Book> findAll() {
        return bookDaoJpa.findAll();
    }

    public Book createBook(Book book) {
        return bookDaoJpa.saveAndFlush(book);
    }

    public Book changeCategory(Long cId, Long bookId) {
        Category category = categoryDaoJpa.findById(cId).get();
        Book book = bookDaoJpa.findById(bookId).get();
        book.setCategory(category);
        return book;
    }
}
