package com.eoruc.backend.user.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaveUserDto implements Serializable {

  private static final long serialVersionUID = -7537129323960736757L;

  private Long userId;

  private String name;
  private String surname;
  private String email;
}
