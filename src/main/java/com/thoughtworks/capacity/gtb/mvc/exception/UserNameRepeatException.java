package com.thoughtworks.capacity.gtb.mvc.exception;

import org.springframework.http.HttpStatus;

public class UserNameRepeatException extends RuntimeException {

  private String errorMessage;

  private HttpStatus status;

  public UserNameRepeatException(String errorMessage) {
    this.errorMessage = errorMessage;
    this.status = HttpStatus.BAD_REQUEST;
  }


}
