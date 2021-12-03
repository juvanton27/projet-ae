package be.vinci.pae.domain.user;

import be.vinci.pae.data.UserDAO;
import jakarta.inject.Inject;

public class UserUCCImpl implements UserUCC {

  @Inject
  private UserDAO userDao;

  @Override
  public User login(String login, String password) {

    return userDao.selectUser(login, password);
  }

}
