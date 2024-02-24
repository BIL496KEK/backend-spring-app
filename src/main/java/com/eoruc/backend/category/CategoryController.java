package com.eoruc.backend.category;

import com.eoruc.backend.category.dto.CategoryDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {
  @Autowired private CategoryService categoryService;

  @GetMapping(path = "/categories")
  public @ResponseBody ResponseEntity<List<CategoryDto>> getCategories() {
    return ResponseEntity.ok(categoryService.getCategories());
  }
}
