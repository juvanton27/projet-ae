package be.vinci.pae.api;

import be.vinci.pae.domain.user.User;
import be.vinci.pae.domain.user.UserFactoryImpl;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Singleton
@Path("/user")
public class UserRessource {

  @Inject
  private UserFactoryImpl userFactory;

  @POST
  @Path("init")
  @Produces(MediaType.APPLICATION_JSON)
  public User init() {
    User user = this.userFactory.getUser();
    return user;
  }


}
