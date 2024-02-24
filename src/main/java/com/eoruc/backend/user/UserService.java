package com.eoruc.backend.user;

import com.eoruc.backend.user.dto.CustomResponseStatusException;
import com.eoruc.backend.user.dto.RegisterUserDto;
import com.eoruc.backend.user.dto.SaveUserDto;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class UserService {

  @Autowired private UserRepository userRepository;
  @Autowired private UserAssembler userAssembler;

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
    return Optional.ofNullable(userRepository.findByEmail(email));
  }
}
