package io.pax.cryptos.ws;

import io.pax.cryptos.dao.UserDao;
import io.pax.cryptos.domain.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by AELION on 09/02/2018.
 */
@Path("users")
@Produces(MediaType.APPLICATION_JSON)
public class UserWs {


    @GET
    public List<User> getWallets() throws SQLException {
        UserDao dao = new UserDao();
        return dao.listUsers();  //listWallets() recupère les données
    }

    @GET
    @Path("{id}") //this is a PathParam
    public User getUser(@PathParam("id") int userId) throws SQLException {
        return new UserDao().findUserWithWallets(userId);
    }
}
