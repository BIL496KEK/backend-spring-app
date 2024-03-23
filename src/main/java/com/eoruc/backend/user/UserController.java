package com.eoruc.backend.user;

import com.eoruc.backend.user.dto.LoginUserDto;
import com.eoruc.backend.user.dto.RegisterUserDto;
import com.eoruc.backend.user.dto.SaveUserDto;
import com.eoruc.backend.user.dto.UserDto;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
public class UserController {

  @Autowired private UserService userService;

  @Autowired private UserAssembler userAssembler;

  @PostMapping(path = "/registration")
  public @ResponseBody ResponseEntity<SaveUserDto> createUser(
      @Valid @RequestBody RegisterUserDto registerUserDto) {
    return ResponseEntity.ok(userService.register(registerUserDto));
  }

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody LoginUserDto loginUserDto) {
    // Perform authentication logic
    // Return appropriate response or token
    System.out.println("Deneme123123123123");
    return ResponseEntity.ok("Login successful");
  }

  @PostMapping("/logout")
  public ResponseEntity<?> logout() {
    // Perform logout logic
    // Invalidate token or session
    return ResponseEntity.ok("Logout successful");
  }

  @GetMapping(path = "/{email}")
  public @ResponseBody ResponseEntity<UserDto> getUserByEmail(
      @PathVariable(name = "email") String email) {
    return ResponseEntity.ok(userService.findUserByEmail(email));
  }
}
