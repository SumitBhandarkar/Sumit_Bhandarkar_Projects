package com.grocery;

public class Wallet {
    private double balance;

    public Wallet(double initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void deduct(double amount) throws InsufficientBalanceException {
        while (balance < amount) {
            System.out.println("Insufficient balance. Adding money...");
            addMoney();
            try {
                wait(); // Wait until balance is sufficient
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore interrupted status
                throw new InsufficientBalanceException("Transaction interrupted: " + e.getMessage());
            }
        }
        balance -= amount;
        System.out.println("Deducted " + amount + " from wallet. Remaining balance: " + balance);
    }

    public synchronized void addMoney() {
        // Simulate adding money (e.g., manual intervention or external payment)
        double addedAmount = 50.0; // Example: Adding 50 units of currency
        balance += addedAmount;
        System.out.println("Added " + addedAmount + " to wallet. New balance: " + balance);
        notify(); // Notify waiting threads that balance has been updated
    }

    public synchronized double getBalance() {
        return balance;
    }
}
