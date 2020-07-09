package com.bookstore.app.services;

import com.bookstore.app.domain.Book;
import com.bookstore.app.domain.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    Category createCategory(Category category);

    List<Book> listBooks(Long cId);
}
