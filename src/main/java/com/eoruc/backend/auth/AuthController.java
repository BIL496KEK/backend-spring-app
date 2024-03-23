package com.eoruc.backend.auth;

import com.eoruc.backend.auth.dto.JwtResponse;
import com.eoruc.backend.auth.dto.MessageResponse;
import com.eoruc.backend.config.security.jwt.JwtUtils;
import com.eoruc.backend.config.security.services.UserDetailsImpl;
import com.eoruc.backend.role.ERole;
import com.eoruc.backend.role.Role;
import com.eoruc.backend.role.RoleRepository;
import com.eoruc.backend.user.User;
import com.eoruc.backend.user.UserRepository;
import com.eoruc.backend.user.dto.LoginUserDto;
import com.eoruc.backend.user.dto.RegisterUserDto;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
  @Autowired AuthenticationManager authenticationManager;

  @Autowired UserRepository userRepository;

  @Autowired RoleRepository roleRepository;

  @Autowired PasswordEncoder encoder;

  @Autowired JwtUtils jwtUtils;

  @PostMapping("/login")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginUserDto loginUserDto) {

    Authentication authentication =
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                loginUserDto.getEmail(), loginUserDto.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);

    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    List<String> roles =
        userDetails.getAuthorities().stream()
            .map(item -> item.getAuthority())
            .collect(Collectors.toList());

    return ResponseEntity.ok(
        new JwtResponse(jwt, "Bearer", userDetails.getId(), userDetails.getEmail(), roles));
  }

  @PostMapping("/register")
  public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterUserDto registerUserDto) {
    if (userRepository.existsByEmail(registerUserDto.getEmail())) {
      return ResponseEntity.badRequest()
          .body(new MessageResponse("Error: Email is already taken!"));
    }

    // Create new user's account
    User user =
        User.builder()
            .password(encoder.encode(registerUserDto.getPassword()))
            .name(registerUserDto.getName())
            .surname(registerUserDto.getSurname())
            .email(registerUserDto.getEmail())
            .birthDate(registerUserDto.getBirthDate())
            .build();

    Set<String> strRoles = registerUserDto.getRole();
    Set<Role> roles = new HashSet<>();

    if (strRoles == null) {
      Role userRole =
          roleRepository
              .findByName(ERole.ROLE_USER)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
      roles.add(userRole);
    } else {
      strRoles.forEach(
          role -> {
            if (role.equals("admin")) {
              Role adminRole =
                  roleRepository
                      .findByName(ERole.ROLE_ADMIN)
                      .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
              roles.add(adminRole);
            } else {
              Role userRole =
                  roleRepository
                      .findByName(ERole.ROLE_USER)
                      .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
              roles.add(userRole);
            }
          });
    }

    user.setRoles(roles);
    userRepository.save(user);

    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
  }
}