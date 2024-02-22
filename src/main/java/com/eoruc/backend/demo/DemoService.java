package com.eoruc.backend.demo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DemoService {
  public String sayHello() {
    log.info("Trying logging!!!!");
    return "Hello, World!!!!";
  }
}
