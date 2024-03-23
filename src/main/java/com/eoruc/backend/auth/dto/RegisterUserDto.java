package com.eoruc.backend.auth.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterUserDto implements Serializable {

  private static final long serialVersionUID = 890918530771218810L;

  @NotBlank(message = "password is mandatory")
  private String password;

  @NotBlank(message = "name is mandatory")
  private String name;

  @NotBlank(message = "surname is mandatory")
  private String surname;

  @Email(regexp = "^$|^(.+)@(.+)$", message = "email is not valid")
  private String email;

  @NotNull private LocalDate birthDate;

  private Set<String> role;
}
