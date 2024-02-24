package com.eoruc.backend.history.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistoryDto {
  private String link;

  private LocalDateTime createdAt;

  private String categoryId;
}
