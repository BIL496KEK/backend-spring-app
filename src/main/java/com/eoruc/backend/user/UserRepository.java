package com.eoruc.backend.user;

import java.time.LocalDate;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByEmail(String email);

  Optional<User> findByEmailAndNameAndSurnameAndBirthDate(
      String email, String name, String surname, LocalDate birthDate);

  Boolean existsByEmail(String email);
}
