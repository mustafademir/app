package com.bookstore.app.services;

import com.bookstore.app.dao.BookDaoJpa;
import com.bookstore.app.dao.CategoryDaoJpa;
import com.bookstore.app.domain.Book;
import com.bookstore.app.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CatagoryServiceImpl implements ICategoryService {
    @Autowired
    private CategoryDaoJpa categoryDaoJpa;

    @Autowired
    private BookDaoJpa bookDaoJpa;

    public List<Category> findAll() {
        return categoryDaoJpa.findAll();
    }

    public Category createCategory(Category category) {
        return categoryDaoJpa.save(category);
    }

    public List<Book> listBooks(Long cId) {
       return bookDaoJpa.findBooksByCategoryId(cId);
    }
}
