package com.eoruc.backend.category;

import com.eoruc.backend.category.dto.CategoryDto;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CategoryService {
  @Autowired private CategoryRepository categoryRepository;
  @Autowired private CategoryAssembler categoryAssembler;

  public List<CategoryDto> getCategories() {
    return categoryAssembler.assembleAllCategories(categoryRepository.findAll());
  }
}
