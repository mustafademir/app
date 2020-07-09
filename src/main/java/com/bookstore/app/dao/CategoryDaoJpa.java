package com.bookstore.app.dao;

import com.bookstore.app.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDaoJpa extends JpaRepository<Category, Long> {
}
