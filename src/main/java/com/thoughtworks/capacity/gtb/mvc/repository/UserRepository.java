package com.thoughtworks.capacity.gtb.mvc.repository;

import com.thoughtworks.capacity.gtb.mvc.common.MockDataBase;
import com.thoughtworks.capacity.gtb.mvc.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

  public List<User> findAll() {
    return MockDataBase.USER_LIST;
  }

  public void save(User user) {
    MockDataBase.USER_LIST.add(user);
    MockDataBase.USER_MAP.put(user.getUsername(), user);
  }

  public boolean isRepeat(String userName) {
    if (MockDataBase.USER_MAP.get(userName) != null) {
      return true;
    }
    return false;
  }

  public int countUser() {
    return MockDataBase.USER_LIST.size();
  }

}
