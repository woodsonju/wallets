package io.pax.cryptos.domain;

/**
 * Created by AELION on 06/02/2018.
 */
public class SimpleWallet implements Wallet{
    int id;
    String name;

    public SimpleWallet(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public User getUser() {
        return null;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }


}
