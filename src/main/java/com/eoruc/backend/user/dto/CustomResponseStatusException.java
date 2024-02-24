package com.eoruc.backend.user.dto;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CustomResponseStatusException extends ResponseStatusException {

  private static final long serialVersionUID = 2728672686462921360L;

  public CustomResponseStatusException(HttpStatus status, String reason, Throwable cause) {
    super(status, reason);
  }

  public CustomResponseStatusException(HttpStatus status, String reason) {
    super(status, reason);
  }
}
