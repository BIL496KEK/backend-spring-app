package com.eoruc.backend.top;

import com.eoruc.backend.top.dto.TopProductDto;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TopProductAssembler {
  public List<TopProductDto> assembleTopProducts(List<TopProduct> products) {
    return products.stream().map(this::assembleTopProduct).collect(Collectors.toList());
  }

  public TopProductDto assembleTopProduct(TopProduct topProduct) {
    return TopProductDto.builder()
        .link(topProduct.getLink())
        .categoryId(topProduct.getCategoryId())
        .count(topProduct.getCount())
        .id(topProduct.getId())
        .createdAt(topProduct.getCreatedAt())
        .build();
  }
}
