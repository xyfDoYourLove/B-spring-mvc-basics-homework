package com.thoughtworks.capacity.gtb.mvc.api;

import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@Validated
public class UserController {

  private UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping(path = "/register")
  @ResponseStatus(HttpStatus.CREATED)
  public void registerUser(@RequestBody @Valid User user) {
    userService.registerUser(user);
  }

  @GetMapping(path = "/login")
  public User login(@RequestParam String username, @RequestParam String password) {
    return userService.login(username, password);
  }

}
