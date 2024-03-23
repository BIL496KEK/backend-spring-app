package com.eoruc.backend.user.dto;

import java.time.LocalDate;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class ForgotPasswordRequest {
  @Email @NotBlank private String email;

  @NotBlank private String name;

  @NotBlank private String surname;

  @NotNull private LocalDate birthDate;

  @NotBlank private String newPassword;
}
