package com.estudo.spring.repositories;

import com.estudo.spring.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query("SELECT book FROM Book book WHERE book.category.id = :id_category ORDER BY book.tittle")
    List<Book> findByCategory(@Param(value = "id_category") Integer id_category);
}
