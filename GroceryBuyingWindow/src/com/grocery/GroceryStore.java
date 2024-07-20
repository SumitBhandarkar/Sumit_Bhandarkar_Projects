package com.grocery;

import java.util.HashMap;
import java.util.Map;

public class GroceryStore {
    private Map<Integer, Map<Integer, GroceryItem>> itemsByCategory = new HashMap<>();
    private Wallet wallet;

    public GroceryStore(double initialBalance) {
        this.wallet = new Wallet(initialBalance);

        // Initialize categories and add initial items
        initializeItems();
    }

    private void initializeItems() {
        // Vegetables (Price per Kilogram)
        Map<Integer, GroceryItem> vegetables = new HashMap<>();
        vegetables.put(1, new GroceryItem("Potato", 15.0, "Vegetables"));
        vegetables.put(2, new GroceryItem("Tomato", 20.0, "Vegetables"));
        vegetables.put(3, new GroceryItem("Gobi (Cauliflower)", 40.0, "Vegetables"));
        itemsByCategory.put(1, vegetables);

        // Fresh Items (Price per Liter)
        Map<Integer, GroceryItem> freshItems = new HashMap<>();
        freshItems.put(1, new GroceryItem("Milk", 60.0, "Fresh Items"));
        freshItems.put(2, new GroceryItem("Curd", 80.0, "Fresh Items"));
        freshItems.put(3, new GroceryItem("Buttermilk", 40.0, "Fresh Items"));
        itemsByCategory.put(2, freshItems);

        // Store Items (Packaged)
        Map<Integer, GroceryItem> storeItems = new HashMap<>();
        storeItems.put(1, new GroceryItem("Sugar", 40.0, "Store Items"));
        storeItems.put(2, new GroceryItem("Salt", 20.0, "Store Items"));
        storeItems.put(3, new GroceryItem("Oil", 90.0, "Store Items"));
        itemsByCategory.put(3, storeItems);
    }

    public void addToBasket(Basket basket, int categoryNumber, int itemNumber) {
        Map<Integer, GroceryItem> categoryItems = itemsByCategory.get(categoryNumber);
        if (categoryItems != null) {
            GroceryItem selected = categoryItems.get(itemNumber);
            if (selected != null) {
                basket.addItem(selected);
            } else {
                System.out.println("Invalid item number.");
            }
        } else {
            System.out.println("Invalid category number.");
        }
    }

    public void goToPayment(Basket basket, User user) {
        double totalCost = basket.calculateTotalCost();
        try {
            wallet.deduct(totalCost);
            System.out.println("Payment successful. Total amount deducted: " + totalCost);
            basket.clearBasket(); // Clear basket after successful payment
        } catch (InterruptedException | InsufficientBalanceException e) {
            System.out.println("Payment failed: " + e.getMessage());
        }
    }
}
