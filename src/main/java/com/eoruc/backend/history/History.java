package com.eoruc.backend.history;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "\"history\"")
@ToString
public class History implements Serializable {
  private static final long serialVersionUID = 7801490296921909606L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @NotBlank(message = "link is mandatory")
  private String link;

  @NotBlank(message = "userId is mandatory")
  private long userId;

  @Column(columnDefinition = "TIMESTAMP")
  @CreationTimestamp
  private LocalDateTime createdAt;

  private String categoryId;
}
