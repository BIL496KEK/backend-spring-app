package com.eoruc.backend.user;

import com.eoruc.backend.user.dto.RegisterUserDto;
import com.eoruc.backend.user.dto.SaveUserDto;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

  @Autowired private UserService userService;

  @PostMapping(path = "/registration")
  public @ResponseBody ResponseEntity<SaveUserDto> createUser(
      @Valid @RequestBody RegisterUserDto registerUserDto) {
    return ResponseEntity.ok(userService.register(registerUserDto));
  }
}
