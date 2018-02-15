package io.pax.cryptos.business;

import io.pax.cryptos.domain.jpa.JpaLine;
import io.pax.cryptos.domain.jpa.JpaWallet;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

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

    public JpaWallet findWallet(int id){
        //Transaction is opened in your back
        JpaWallet w = em.find(JpaWallet.class, id);
        String jpql = "SELECT l FROM JpaLine l JOIN l.wallet w WHERE w.id = :id";
        List<JpaLine> lines = em.createQuery(jpql, JpaLine.class)
                .setParameter("id", id)
                .getResultList();

        System.out.println(lines);

        w.setLines(lines);

        return w;

    }//and now closed
}
