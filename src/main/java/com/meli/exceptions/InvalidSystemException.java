package com.meli.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidSystemException extends RuntimeException {
  public InvalidSystemException(String message) {
    super(message);
  }
}
