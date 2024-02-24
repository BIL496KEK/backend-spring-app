package com.eoruc.backend.top;

import com.eoruc.backend.top.dto.TopProductDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopProductController {
  @Autowired private TopProductService topProductService;
  @Autowired private TopProductAssembler topProductAssembler;

  @GetMapping(path = "/top-prodcuts")
  public @ResponseBody ResponseEntity<List<TopProductDto>> getTopProducts() {
    return ResponseEntity.ok(topProductService.getTopProducts());
  }
}
