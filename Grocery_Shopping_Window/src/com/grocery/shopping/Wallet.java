package com.grocery.shopping;

public class Wallet {
    private double balance;

    public Wallet(double balance) {
        this.balance = balance;
    }

    public boolean deduct(double amount) throws InsufficientFundsException {
        if (balance >= amount) {
            balance -= amount;
            return true;
        } else {
            throw new InsufficientFundsException("Insufficient funds in wallet. Add more funds to proceed.");
        }
    }

    public void addFunds(double amount) {
        balance += amount;
    }

    @Override
    public String toString() {
        return "Wallet balance: " + balance + " rs";
    }
}
