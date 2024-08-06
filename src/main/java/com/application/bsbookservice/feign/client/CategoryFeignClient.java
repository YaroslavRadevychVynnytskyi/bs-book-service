package com.application.bsbookservice.feign.client;

import com.application.bsbookservice.dto.category.CategoryByIdsRequestDto;
import com.application.bsbookservice.dto.category.CategoryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@FeignClient(name = "bs-category-service", url = "${categories.service.url}")
public interface CategoryFeignClient {
    @PostMapping("/details-by-ids")
    List<CategoryDto> getCategoryDetailsByIds(@RequestBody CategoryByIdsRequestDto requestDto);
}
