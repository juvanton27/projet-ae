package be.vinci.pae.data;

import be.vinci.pae.domain.user.User;

public interface UserDAO {
  User selectUser(String pseudo, String password);

}
