package be.vinci.pae.domain.user;

import jakarta.inject.Inject;

public class UserFactoryImpl implements UserFactory {

  @Inject
  public User getUser() {
    return new UserImpl();
  }

}
