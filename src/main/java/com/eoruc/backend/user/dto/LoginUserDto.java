package com.eoruc.backend.user.dto;

import java.io.Serializable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginUserDto implements Serializable {
  private static final long serialVersionUID = -4928963728407133178L;

  @Email @NotBlank private String email;

  @NotBlank private String password;
}
