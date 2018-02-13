package io.pax.cryptos.domain.jpa;

import io.pax.cryptos.domain.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AELION on 13/02/2018.
 */
@Entity            //objet en base de donnée
public class JpaUser implements User{

    @Id     //primary key
   @GeneratedValue(strategy = GenerationType.AUTO) // ajout un auto - incrementation
    int id;
    String name;
   // List<Wallet> wallets = new ArrayList<>();

    @OneToMany
    List<JpaWallet> wallets = new ArrayList<>();

    //unwritten default empty constructor
    public JpaUser() {
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public List<JpaWallet> getWallets() {
        return this.wallets; //this.wallets;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return this.getName();
    }
}
