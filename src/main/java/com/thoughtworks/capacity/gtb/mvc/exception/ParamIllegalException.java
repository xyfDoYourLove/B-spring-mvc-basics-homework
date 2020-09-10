package com.thoughtworks.capacity.gtb.mvc.exception;

public class ParamIllegalException extends RuntimeException {

  private String errorMessage;

  public ParamIllegalException(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  @Override
  public String getMessage() {
    return errorMessage;
  }
}
