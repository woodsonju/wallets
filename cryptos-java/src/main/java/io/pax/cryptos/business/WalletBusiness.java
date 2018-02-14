package io.pax.cryptos.business;

import io.pax.cryptos.domain.Wallet;
import io.pax.cryptos.domain.jpa.JpaWallet;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by AELION on 06/02/2018.
 */

/**
 * Stateless: It is a Java EE Managed EJB
 * EJB is a Super Object that does everything in your back
 */
@Stateless
public class WalletBusiness {

    //EntityManager is given by Wildfly. It's a managed object
    @PersistenceContext
    EntityManager em;

    public Wallet findWallet(int id){
        //Transaction is opened in your back
        return em.find(JpaWallet.class, id);
    }//and now closed
}
