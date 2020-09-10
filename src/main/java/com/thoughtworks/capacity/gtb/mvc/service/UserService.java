package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.common.ExceptionMessageConstant;
import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.exception.UserNameRepeatException;
import com.thoughtworks.capacity.gtb.mvc.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public void registerUser(User user) throws UserNameRepeatException {
    if (userRepository.isRepeat(user.getUsername())) {
      throw new UserNameRepeatException(ExceptionMessageConstant.USERNAME_REPEAT);
    }
    user.setId(userRepository.countUser() + 1);
    userRepository.save(user);
  }
}
