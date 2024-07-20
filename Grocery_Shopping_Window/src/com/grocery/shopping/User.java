package com.grocery.shopping;

public class User {
    private String name;
    private Wallet wallet;

    public User(String name, double initialBalance) {
        this.name = name;
        this.wallet = new Wallet(initialBalance);
    }

    public String getName() {
        return name;
    }

    public Wallet getWallet() {
        return wallet;
    }

    @Override
    public String toString() {
        return "User: " + name + "\n" + wallet;
    }
}
