package com.bookstore.app.services;

import com.bookstore.app.dao.BookDaoJpa;
import com.bookstore.app.dao.CategoryDaoJpa;
import com.bookstore.app.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    @Transactional
    public Integer changeCategory(Long cId, Long bookId) {
        return bookDaoJpa.updateCategoryId(cId,bookId);
    }
}
