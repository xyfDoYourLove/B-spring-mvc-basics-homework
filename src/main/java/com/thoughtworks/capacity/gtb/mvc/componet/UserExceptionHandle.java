package com.thoughtworks.capacity.gtb.mvc.componet;

import com.thoughtworks.capacity.gtb.mvc.exception.Error;
import com.thoughtworks.capacity.gtb.mvc.exception.ParamIllegalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class UserExceptionHandle {

  @ExceptionHandler(value = {MethodArgumentNotValidException.class, ParamIllegalException.class})
  public ResponseEntity<Error> UserValidExceptionHandle(Exception exception) {
    Error error = new Error();
    if (exception instanceof MethodArgumentNotValidException) {
      error.setError(((MethodArgumentNotValidException) exception).getBindingResult().getFieldError().getDefaultMessage());
    }else {
      error.setError(exception.getMessage());
    }
    return ResponseEntity.badRequest().body(error);
  }

}
