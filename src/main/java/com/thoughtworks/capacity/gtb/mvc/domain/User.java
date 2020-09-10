package com.thoughtworks.capacity.gtb.mvc.domain;

import com.thoughtworks.capacity.gtb.mvc.common.ExceptionMessageConstant;
import lombok.Data;

import javax.validation.constraints.*;

@Data
public class User {

  private int id;

  @NotNull(message = ExceptionMessageConstant.USERNAME_NOT_NULL)
  @NotEmpty(message = ExceptionMessageConstant.USERNAME_NOT_NULL)
  @Pattern(regexp = "^[0-9a-zA-Z_]{3,10}$", message = ExceptionMessageConstant.USERNAME_ILLEGAL)
  private String username;

  @NotNull(message = ExceptionMessageConstant.PASSWORD_NOT_NULL)
  @NotEmpty(message = ExceptionMessageConstant.PASSWORD_NOT_NULL)
  @Size(min = 5, max = 12, message = ExceptionMessageConstant.PASSWORD_ILLEGAL)
  private String password;

  @Email(message = ExceptionMessageConstant.EMAIL_ILLEGAL)
  private String email;

}
