package com.eoruc.backend.user;

import com.eoruc.backend.auth.dto.RegisterUserDto;
import com.eoruc.backend.auth.token.RefreshTokenService;
import com.eoruc.backend.user.dto.*;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class UserService {

  @Autowired private UserRepository userRepository;

  @Autowired private RefreshTokenService refreshTokenService;
  @Autowired private UserAssembler userAssembler;
  @Autowired PasswordEncoder encoder;

  public User saveNewUser(User user) {
    user.setEmail(user.getEmail().toLowerCase());
    return userRepository.save(user);
  }

  @Transactional
  public SaveUserDto register(RegisterUserDto registerUserDto) {

    if (findByEmail(registerUserDto.getEmail()).isPresent()) {
      throw new CustomResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "user.exist");
    }

    User savedUser = saveNewUser(userAssembler.assembleForRegistration(registerUserDto));

    return userAssembler.assembleRegistrationResponse(savedUser);
  }

  public Optional<User> findByEmail(String email) {
    return userRepository.findByEmail(email);
  }

  public UserDto findUserByEmail(String email) {
    Optional<User> user = findByEmail(email);

    return user.map(value -> userAssembler.assemble(value)).orElse(null);
  }

  public void forgotPassword(ForgotPasswordRequest forgotPasswordRequest) {
    Optional<User> user =
        userRepository.findByEmailAndNameAndSurnameAndBirthDate(
            forgotPasswordRequest.getEmail(),
            forgotPasswordRequest.getName(),
            forgotPasswordRequest.getSurname(),
            forgotPasswordRequest.getBirthDate());

    if (user.isEmpty()) {
      throw new CustomResponseStatusException(HttpStatus.NOT_FOUND, "user.not.found");
    }

    user.get().setPassword(encoder.encode(forgotPasswordRequest.getNewPassword()));

    refreshTokenService.deleteByUserId(user.get().getId());
    userRepository.save(user.get());
  }
}
