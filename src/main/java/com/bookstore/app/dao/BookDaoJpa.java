package com.bookstore.app.dao;

import com.bookstore.app.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDaoJpa extends JpaRepository<Book,Long> {
    @Query("SELECT u FROM Book u WHERE u.category.category_id = ?1")
    List<Book> findBooksByCategoryId(Long cId);

    @Query("SELECT u FROM Book u WHERE u.category.category_id = ?1")
    List<Book> findBooksByBookstore(Long cId);

    @Modifying
    @Query("UPDATE Book u SET u.category.category_id = :cId where u.book_id = :bookId")
    Integer updateCategoryId(@Param("cId") Long cId,@Param("bookId") Long bookId);
}
