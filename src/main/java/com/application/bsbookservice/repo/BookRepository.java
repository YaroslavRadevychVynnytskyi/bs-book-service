package com.application.bsbookservice.repo;

import com.application.bsbookservice.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    @EntityGraph(attributePaths = {"categoryIds"})
    Page<Book> findAll(Pageable pageable);

    @EntityGraph(attributePaths = {"categoryIds"})
    Optional<Book> findById(Long bookId);
}
