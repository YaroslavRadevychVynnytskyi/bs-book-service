package com.application.bsbookservice.dto.book;

import com.application.bsbookservice.dto.category.CategoryDto;
import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

@Data
public class BookDto {
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private BigDecimal price;
    private String description;
    private String coverImage;
    private List<CategoryDto> categories;
}
