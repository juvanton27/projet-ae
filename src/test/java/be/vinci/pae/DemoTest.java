package be.vinci.pae;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import be.vinci.pae.config.ApplicationBinder;
import be.vinci.pae.domain.user.User;
import be.vinci.pae.domain.user.UserUCC;
import be.vinci.pae.exception.MissingFieldException;
import be.vinci.pae.exception.UserException;

@DisplayName("Classe de test du package authentification")
public class DemoTest {

  private static UserUCC userUCC;

  @BeforeAll
  static void initAll() {
    ServiceLocator locator = ServiceLocatorUtilities.bind(new ApplicationBinder());

    userUCC = locator.getService(UserUCC.class);
  }

  @BeforeEach
  void setUp() {

  }

  @DisplayName("Authentification de l'utilisateur : succès 1")
  @Test
  public void testConnexionSucces() {
    assertNotNull(userUCC.login("ezerun", "ezerun"));
  }

  @DisplayName("Authentification de l'utilisateur : utilisateur pas encore inscrit")
  @Test
  public void testUtilisateurInconnu() {
    assertThrows(UserException.class, () -> userUCC.login("test", "test"));
  }

  @DisplayName("Authentification de l'utilisateur : aucun champ rempli")
  @Test
  public void testChampsVides() {
    assertThrows(MissingFieldException.class, () -> userUCC.login("", ""));
  }

  @DisplayName("Authentification de l'utilisateur : champ \"pseudo\" manquant")
  @Test
  public void testPseudoVide() {
    assertThrows(MissingFieldException.class, () -> userUCC.login("", "test"));
  }

  @DisplayName("Authentification de l'utilisateur : champ \"mot de passe\" manquant")
  @Test
  public void testMdpVide() {
    assertThrows(MissingFieldException.class, () -> userUCC.login("test", ""));
  }

  @DisplayName("Mot de passe chiffrer")
  @Test
  public void testChiffrer() {
    User user = userUCC.login("ezerun", "ezerun");
    user.hashPassword();
    assertTrue(user.checkPwd("ezerun"));
  }

}
