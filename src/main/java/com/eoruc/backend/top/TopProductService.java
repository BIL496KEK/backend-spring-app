package com.eoruc.backend.top;

import com.eoruc.backend.top.dto.TopProductDto;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TopProductService {
  @Autowired private TopProductRepository topProductRepository;
  @Autowired private TopProductAssembler topProductAssembler;

  public List<TopProductDto> getTopProducts() {
    return topProductAssembler.assembleTopProducts(topProductRepository.findAll());
  }
}
