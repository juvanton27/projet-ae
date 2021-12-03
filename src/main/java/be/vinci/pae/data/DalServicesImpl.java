package be.vinci.pae.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import be.vinci.pae.config.Config;

public class DalServicesImpl implements DalServices {

  private Connection connection;

  public DalServicesImpl() throws SQLException {
    super();

    Config.load("dev.properties");

    String url = Config.getProperty("url");
    String user = Config.getProperty("user");
    String password = Config.getProperty("password");

    try {
      this.setConnection(DriverManager.getConnection(url, user, password));
    } catch (SQLException sqlException) {
      sqlException.printStackTrace();
      System.out.println("impossible joindre serveur");
      System.exit(1);
    }

  }

  public Connection getConnection() {
    return connection;
  }

  public void setConnection(Connection connection) {
    this.connection = connection;
  }

  public PreparedStatement getPrepareStatement(String sql) {

    PreparedStatement pr = null;
    try {
      pr = this.connection.prepareStatement(sql);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return pr;

  }



}
