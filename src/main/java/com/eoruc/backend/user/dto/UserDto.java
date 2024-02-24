package com.eoruc.backend.user.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto implements Serializable {

  private static final long serialVersionUID = -7537129323960736757L;

  private Long userId;

  private String password;
  private String name;
  private String surname;
  private Status status;
  private String email;
  private String deviceId;
  private LocalDateTime lastSuccessfulLoginDate;
  private LocalDateTime lastUnsuccessfulLoginDate;

  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate birthDate;
}
