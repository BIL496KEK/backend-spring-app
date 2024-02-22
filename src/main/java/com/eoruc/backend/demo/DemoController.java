package com.eoruc.backend.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class DemoController {

  private final DemoService demoService;

  @GetMapping(path = "/say-hello")
  public String sayHello() {
    return demoService.sayHello();
  }
}
