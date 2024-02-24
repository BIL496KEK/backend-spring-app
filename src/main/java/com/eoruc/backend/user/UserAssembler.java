package com.eoruc.backend.user;

import com.eoruc.backend.user.dto.RegisterUserDto;
import com.eoruc.backend.user.dto.SaveUserDto;
import com.eoruc.backend.user.dto.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserAssembler {
  public User assembleForRegistration(RegisterUserDto registerUserDto) {
    return User.builder()
        .status(Status.ACTIVE)
        .password(registerUserDto.getPassword())
        .name(registerUserDto.getName())
        .surname(registerUserDto.getSurname())
        .email(registerUserDto.getEmail())
        .birthDate(registerUserDto.getBirthDate())
        .build();
  }

  public SaveUserDto assembleRegistrationResponse(User user) {
    return SaveUserDto.builder()
        .name(user.getName())
        .surname(user.getSurname())
        .email(user.getEmail())
        .userId(user.getId())
        .build();
  }
}
