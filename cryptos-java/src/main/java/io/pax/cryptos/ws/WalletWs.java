package io.pax.cryptos.ws;

import io.pax.cryptos.dao.WalletDao;
import io.pax.cryptos.domain.Wallet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by AELION on 06/02/2018.
 */
@Path("wallets")
@Produces(MediaType.APPLICATION_JSON)

public class WalletWs {

    @GET
    public List<Wallet> getWallets() throws SQLException {
        WalletDao dao = new WalletDao();
        return dao.listWallets();  //listWallets() recupère les données
    }
}
