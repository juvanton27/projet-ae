package be.vinci.pae.domain.user;

import java.util.Date;

public interface UserDTO {
  void setID(int id);

  void setPseudo(String string);

  void setNom(String string);

  void setPrenom(String string);

  void setAdresse(String string);

  void setEmail(String string);

  void setMdp(String string);

  void setDate(Date date);

  void setStatus(char status);

  int getID();

  String getPseudo();

  String getMdp();
}
