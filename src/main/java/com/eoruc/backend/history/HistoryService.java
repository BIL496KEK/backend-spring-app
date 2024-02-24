package com.eoruc.backend.history;

import com.eoruc.backend.history.dto.HistoryDto;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HistoryService {
  @Autowired private HistoryRepository historyRepository;
  @Autowired private HistoryAssembler historyAssembler;

  public List<HistoryDto> getHistoryByUserId(Long userId) {
    return historyAssembler.assembleAllHistories(historyRepository.findAllByUserId(userId));
  }
}
