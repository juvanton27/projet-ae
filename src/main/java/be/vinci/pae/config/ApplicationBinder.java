package be.vinci.pae.config;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

import be.vinci.pae.data.DalServices;
import be.vinci.pae.data.DalServicesImpl;
import be.vinci.pae.data.MockUserDAO;
import be.vinci.pae.data.UserDAO;
import be.vinci.pae.domain.user.User;
import be.vinci.pae.domain.user.UserFactory;
import be.vinci.pae.domain.user.UserFactoryImpl;
import be.vinci.pae.domain.user.UserImpl;
import be.vinci.pae.domain.user.UserUCC;
import be.vinci.pae.domain.user.UserUCCImpl;
import jakarta.inject.Singleton;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ApplicationBinder extends AbstractBinder {

  @Override
  protected void configure() {

    /*
     * Mettre ici les liens vers les classes à charger
     * 
     */

    bind(DalServicesImpl.class).to(DalServices.class).in(Singleton.class);
    bind(UserUCCImpl.class).to(UserUCC.class).in(Singleton.class);
    bind(MockUserDAO.class).to(UserDAO.class).in(Singleton.class);
    bind(UserImpl.class).to(User.class).in(Singleton.class);
    bind(UserFactoryImpl.class).to(UserFactory.class).in(Singleton.class);
  }
}
