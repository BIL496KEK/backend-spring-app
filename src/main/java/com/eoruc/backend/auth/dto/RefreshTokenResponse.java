package com.eoruc.backend.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class RefreshTokenResponse {
  private String accessToken;
  private String refreshToken;
  private String tokenType;
}
