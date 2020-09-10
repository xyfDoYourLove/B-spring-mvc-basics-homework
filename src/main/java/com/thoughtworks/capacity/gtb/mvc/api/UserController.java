package com.thoughtworks.capacity.gtb.mvc.api;

import com.thoughtworks.capacity.gtb.mvc.common.ExceptionMessageConstant;
import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

@RestController
@Validated
public class UserController {

  UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping(path = "/register")
  public ResponseEntity<String> registerUser(@RequestBody @Valid User user) throws RuntimeException {
    userService.registerUser(user);
    return ResponseEntity.ok().build();
  }

  @GetMapping(path = "/login")
  public ResponseEntity<User> login(
          @RequestParam(required = true) String username,
          @RequestParam(required = true) String password) {
    User loginInfo = userService.login(username, password);
    return ResponseEntity.ok(loginInfo);
  }

}
