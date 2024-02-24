package com.eoruc.backend.top.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TopProductDto {
  private long id;

  private String link;

  private LocalDateTime createdAt;

  private Long count;

  private String categoryId;
}
