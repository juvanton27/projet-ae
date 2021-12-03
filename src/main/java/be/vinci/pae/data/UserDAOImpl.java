package be.vinci.pae.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import be.vinci.pae.domain.user.User;
import be.vinci.pae.domain.user.UserFactory;
import be.vinci.pae.exception.MissingFieldException;
import be.vinci.pae.exception.UserException;
import jakarta.inject.Inject;

public class UserDAOImpl implements UserDAO {

  private final DalServices dsi;
  private final UserFactory userFactory;

  @Inject
  public UserDAOImpl(DalServices dsi, UserFactory userFactory) throws Exception {
    this.dsi = dsi;
    this.userFactory = userFactory;
  }

  public User selectUser(String login, String password) {
    if (login.equals("") || password.equals(""))
      throw new MissingFieldException();
    User user = userFactory.getUser();
    String sql = "SELECT cl.* FROM clients cl WHERE cl.pseudo = ? AND cl.mdp = ?";
    try {
      PreparedStatement pr = dsi.getPrepareStatement(sql);
      pr.setString(1, login);
      pr.setString(2, password);
      ResultSet rs = pr.executeQuery();
      if (rs.next()) {
        user.setID(rs.getInt(1));
        user.setPseudo(rs.getString(2));
        user.setNom(rs.getString(3));
        user.setPrenom(rs.getString(4));
        user.setAdresse(rs.getString(5));
        user.setEmail(rs.getString(6));
        user.setMdp(rs.getString(7));
        user.setDate(rs.getDate(8));
        user.setStatus(rs.getString(9).charAt(0));

      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    if (user.getID() == 0) {
      throw new UserException();
    } else
      return user;
  }


}
