package be.vinci.pae.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

  private static Properties properties = new Properties();

  /**
   * @param file -> file
   */
  public static void load(String file) {
    try (InputStream input = new FileInputStream(file)) {
      properties.load(input);
    } catch (IOException e) {
      throw new FatalException(e);
    }
  }


  public static String getProperty(String key) {
    return properties.getProperty(key).toString();
  }

  /**
   * @param key -> key
   * @return la value de la key en Integer.
   */
  public static Integer getIntProperty(String key) {
    return Integer.parseInt(properties.getProperty(key));
  }

  /**
   * @param key -> key.
   * @return la value de la key en Boolean.
   */
  public static boolean getBoolProperty(String key) {
    return Boolean.parseBoolean(properties.getProperty(key));
  }


}
