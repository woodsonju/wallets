package io.pax.cryptos.domain.jpa;

import io.pax.cryptos.domain.User;
import io.pax.cryptos.domain.Wallet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by AELION on 13/02/2018.
 */
@Entity
public class JpaWallet implements Wallet {

    @Id                     //primary key
    @GeneratedValue(strategy = GenerationType.AUTO)// ajout un auto - incrementation
    int id;

    String name;

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public User getUser() {
        //always null, avoid problems
        return null;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
