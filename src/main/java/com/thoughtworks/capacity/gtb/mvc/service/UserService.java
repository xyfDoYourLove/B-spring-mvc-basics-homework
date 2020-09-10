package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.common.ExceptionMessageConstant;
import com.thoughtworks.capacity.gtb.mvc.common.MockDataBase;
import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.exception.ParamIllegalException;
import com.thoughtworks.capacity.gtb.mvc.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class UserService {

  UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public void registerUser(User user) throws ParamIllegalException {
    if (userRepository.isRepeat(user.getUsername())) {
      throw new ParamIllegalException(ExceptionMessageConstant.USERNAME_REPEAT);
    }
    user.setId(userRepository.countUser() + 1);
    userRepository.save(user);
  }

  public User login(String username, String password) {
    checkParamLegal(username, password);
    return userRepository.findOne(username);
  }

  private void checkParamLegal(String username, String password) {
    if (!Pattern.matches("^[0-9a-zA-Z_]{3,10}$", username)) {
      throw new ParamIllegalException(ExceptionMessageConstant.USERNAME_ILLEGAL);
    }
    if (!Pattern.matches("^.{5,12}$", password)) {
      throw new ParamIllegalException(ExceptionMessageConstant.PASSWORD_ILLEGAL);
    }
    if (MockDataBase.USER_MAP.get(username) == null || !password.equals(MockDataBase.USER_MAP.get(username).getPassword())) {
      throw new ParamIllegalException(ExceptionMessageConstant.USERNAME_PASSWORD_WRONG);
    }
  }
}
