package com.application.bsbookservice.service.impl;

import com.application.bsbookservice.dto.book.BookDto;
import com.application.bsbookservice.dto.category.CategoryByIdsRequestDto;
import com.application.bsbookservice.feign.client.CategoryFeignClient;
import com.application.bsbookservice.mapper.BookMapper;
import com.application.bsbookservice.model.Book;
import com.application.bsbookservice.repo.BookRepository;
import com.application.bsbookservice.service.BookService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    private final CategoryFeignClient categoryFeignClient;

    @Override
    public List<BookDto> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable).stream()
                .map(this::convertToBookDto)
                .toList();
    }

    @Override
    public BookDto getBookById(Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() ->
                new EntityNotFoundException("Book with ID: " + bookId + " not found"));

        return convertToBookDto(book);
    }

    private BookDto convertToBookDto(Book book) {
        BookDto bookDto = bookMapper.toDto(book);

        CategoryByIdsRequestDto requestDto = new CategoryByIdsRequestDto(book.getCategoryIds());
        bookDto.setCategories(categoryFeignClient.getCategoryDetailsByIds(requestDto));
        return bookDto;
    }
}
