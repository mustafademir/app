package com.bookstore.app.dao;

import com.bookstore.app.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDaoJpa extends JpaRepository<Book,Long> {

}
