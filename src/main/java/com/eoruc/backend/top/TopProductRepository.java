package com.eoruc.backend.top;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface TopProductRepository extends CrudRepository<TopProduct, Long> {
  List<TopProduct> findAll();
}
