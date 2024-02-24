package com.eoruc.backend.category.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDto {
  private long id;
  private String categoryName;
  private LocalDateTime createdAt;
  private Long count;
}
