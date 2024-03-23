package com.eoruc.backend.user;

import com.eoruc.backend.user.dto.*;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {

  @Autowired private UserService userService;

  @Autowired private UserAssembler userAssembler;

  @GetMapping(path = "/{email}")
  public @ResponseBody ResponseEntity<UserDto> getUserByEmail(
      @PathVariable(name = "email") String email) {
    return ResponseEntity.ok(userService.findUserByEmail(email));
  }

  @PostMapping("/forgot-password")
  public ResponseEntity<?> forgotPassword(
      @Valid @RequestBody ForgotPasswordRequest forgotPasswordRequest) {
    userService.forgotPassword(forgotPasswordRequest);
    return ResponseEntity.ok().build();
  }
}
