package io.pax.cryptos.ws;

import io.pax.cryptos.dao.UserDao;
import io.pax.cryptos.domain.FullUser;
import io.pax.cryptos.domain.User;
import io.pax.cryptos.domain.Wallet;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AELION on 09/02/2018.
 */
@Path("users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

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

    //JaxRS annotations
    @POST
    public User createUser(FullUser user){
        String userName = user.getName();
        List<Wallet> wallets = new ArrayList<>();

        if(userName == null)
        {
            throw new NotAcceptableException("406: No user id sent");
        }

        if(userName.length() < 2)
        {
            throw new NotAcceptableException("406: wallet name must have at least 2 letters");
        }

        try {
            int id = new UserDao().createUser(userName);
            return new FullUser(id, userName, wallets);
        } catch (SQLException e) {
            throw new ServerErrorException("DataBase error, sorry", 500);
        }
    }

}
