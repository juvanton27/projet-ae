package be.vinci.pae.domain.user;

public interface User extends UserDTO {

  String toString();

  boolean checkCanBeAdmin();

  void changeToAdmin();

  boolean hashPassword();

  boolean checkPwd(String motDePasseNonHashe);

}
