package com.eoruc.backend.category;

import com.eoruc.backend.category.dto.CategoryDto;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryAssembler {
  public List<CategoryDto> assembleAllCategories(List<Category> categories) {
    return categories.stream().map(this::assembleCategory).collect(Collectors.toList());
  }

  private CategoryDto assembleCategory(Category category) {
    return CategoryDto.builder()
        .id(category.getId())
        .categoryName(category.getCategoryName())
        .count(category.getCount())
        .createdAt(category.getCreatedAt())
        .build();
  }
}
