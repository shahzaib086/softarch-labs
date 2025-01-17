package org.example.structural.repository;


import org.example.structural.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    // Additional query methods can be defined here if needed

    List<Book> findByIsFeaturedTrue();
}
