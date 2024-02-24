package com.eoruc.backend.history;

import com.eoruc.backend.history.dto.HistoryDto;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HistoryAssembler {
  public List<HistoryDto> assembleAllHistories(List<History> history) {
    return history.stream().map(this::assembleHistory).collect(Collectors.toList());
  }

  private HistoryDto assembleHistory(History history) {
    return HistoryDto.builder()
        .link(history.getLink())
        .categoryId(history.getCategoryId())
        .createdAt(history.getCreatedAt())
        .build();
  }
}
