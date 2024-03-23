package com.eoruc.backend.user;

import com.eoruc.backend.role.Role;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(
    name = "users",
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
  @Column(unique = true)
  private String email;

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

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
      name = "user_roles",
      joinColumns = @JoinColumn(name = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();
}
