package com.application.bsbookservice.mapper;

import com.application.bsbookservice.config.MapperConfig;
import com.application.bsbookservice.dto.book.BookDto;
import com.application.bsbookservice.model.Book;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface BookMapper {
    BookDto toDto(Book book);
}
