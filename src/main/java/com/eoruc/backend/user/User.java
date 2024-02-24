package com.eoruc.backend.user;

import com.eoruc.backend.user.dto.Status;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(
    name = "\"users\"",
    uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
@ToString
public class User implements Serializable {
  private static final long serialVersionUID = -8592055929932789334L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @NotBlank(message = "Password is mandatory")
  private String password;

  @NotBlank(message = "Name is mandatory")
  private String name;

  @NotBlank(message = "Surname is mandatory")
  private String surname;

  @Email(regexp = "^$|^(.+)@(.+)$", message = "Email is not valid")
  private String email;

  @Enumerated(EnumType.STRING)
  private Status status;

  private String deviceId;

  private int unsuccessfullLoginCount;

  @NotNull private LocalDate birthDate;

  @Column(columnDefinition = "TIMESTAMP")
  @CreationTimestamp
  private LocalDateTime createdAt;

  @Column(columnDefinition = "TIMESTAMP")
  @UpdateTimestamp
  private LocalDateTime updatedAt;

  @Column(columnDefinition = "TIMESTAMP")
  @UpdateTimestamp
  private LocalDateTime lastSuccessfulLoginDate;

  @Column(columnDefinition = "TIMESTAMP")
  private LocalDateTime lastUnsuccessfulLoginDate;
}
