package be.vinci.pae.data;

import be.vinci.pae.domain.user.User;
import be.vinci.pae.domain.user.UserFactory;
import be.vinci.pae.domain.user.UserFactoryImpl;
import be.vinci.pae.exception.MissingFieldException;
import be.vinci.pae.exception.UserException;

public class MockUserDAO implements UserDAO {

  UserFactory ufi;

  public MockUserDAO() {
    this.ufi = new UserFactoryImpl();
  }

  @Override
  public User selectUser(String pseudo, String password) {
    User user = ufi.getUser();
    if (pseudo.equals("") || password.equals("")) {
      throw new MissingFieldException();
    }
    user.setPseudo(pseudo);
    user.setMdp(password);
    if (user.getPseudo() == "ezerun") {
      return user;
    }
    if (user.getID() == 0) {
      throw new UserException();
    } else {
      return user;
    }

  }

}
