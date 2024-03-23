package com.eoruc.backend.auth.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {
  private String token;
  private String type;
  private String refreshToken;
  private Long id;
  private String email;
  private List<String> roles;
}
