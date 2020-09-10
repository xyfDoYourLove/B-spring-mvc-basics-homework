package com.thoughtworks.capacity.gtb.mvc.repository;

import com.thoughtworks.capacity.gtb.mvc.common.MockDataBase;
import com.thoughtworks.capacity.gtb.mvc.domain.User;

import java.util.List;

public class UserRepository {

  public List<User> findAll() {
    return MockDataBase.USER_LIST;
  }

  public void save(User user) {
    MockDataBase.USER_LIST.add(user);
    MockDataBase.USER_MAP.put(user.getUsername(), user);
  }

}
