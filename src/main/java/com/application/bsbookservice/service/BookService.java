package com.application.bsbookservice.service;

import com.application.bsbookservice.dto.book.BookDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {
    List<BookDto> findAll(Pageable pageable);

    BookDto getBookById(Long bookId);
}
