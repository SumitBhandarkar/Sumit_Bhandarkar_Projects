package com.grocery;

import java.util.Scanner;

public class Main {
    private static GroceryStore store = new GroceryStore(500); // Initial balance for the store's wallet
    private static Basket basket = new Basket();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    showCategories();
                    break;
                case 2:
                    addItemToBasket();
                    break;
                case 3:
                    viewBasket();
                    break;
                case 4:
                    goToPayment();
                    break;
                case 5:
                    clearBasket();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nWelcome to Grocery Store");
        System.out.println("1. Show Categories");
        System.out.println("2. Add Item to Basket");
        System.out.println("3. View Basket");
        System.out.println("4. Go to Payment");
        System.out.println("5. Clear Basket");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void showCategories() {
        System.out.println("\nCategories:");
        System.out.println("1. Vegetables (Price per Kilogram)");
        showItems(store, 1);
        System.out.println("2. Fresh Items (Price per Liter)");
        showItems(store, 2);
        System.out.println("3. Store Items (Packaged)");
        showItems(store, 3);
    }

    private static void showItems(GroceryStore store, int categoryNumber) {
        Map<Integer, GroceryItem> items = store.getItemsByCategory().get(categoryNumber);
        if (items != null) {
            for (Map.Entry<Integer, GroceryItem> entry : items.entrySet()) {
                System.out.println(entry.getKey() + ". " + entry.getValue());
            }
        }
    }

    private static void addItemToBasket() {
        System.out.print("Enter category number: ");
        int categoryNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        System.out.print("Enter item number: ");
        int itemNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        store.addToBasket(basket, categoryNumber, itemNumber);
    }

    private static void viewBasket() {
        System.out.println("\nItems in Basket:");
        for (GroceryItem item : basket.getItems()) {
            System.out.println(item);
        }
    }

    private static void clearBasket() {
        basket.clearBasket();
    }

    private static void goToPayment() {
        store.goToPayment(basket, new User("John Doe", 500)); // Example: User with initial balance of 500
    }
}
