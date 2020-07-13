package com.bookstore.app.dao;

import com.bookstore.app.domain.Bookstore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookstoreDaoJpa extends JpaRepository<Bookstore,Long> {
}
