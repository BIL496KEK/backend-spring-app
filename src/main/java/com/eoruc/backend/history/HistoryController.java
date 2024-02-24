package com.eoruc.backend.history;

import com.eoruc.backend.history.dto.HistoryDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HistoryController {
  @Autowired private HistoryService historyService;

  @Autowired private HistoryAssembler historyAssembler;

  @GetMapping(path = "history/{userId}")
  public @ResponseBody ResponseEntity<List<HistoryDto>> getHistoryByUserId(
      @PathVariable(name = "userId") Long userId) {
    return ResponseEntity.ok(historyService.getHistoryByUserId(userId));
  }
}
