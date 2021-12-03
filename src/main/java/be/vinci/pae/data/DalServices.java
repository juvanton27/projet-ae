package be.vinci.pae.data;

import java.sql.PreparedStatement;

public interface DalServices {

  PreparedStatement getPrepareStatement(String sql);

}
