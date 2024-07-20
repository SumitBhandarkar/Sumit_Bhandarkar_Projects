package com.grocery;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<GroceryItem> items;

    public Basket() {
        this.items = new ArrayList<>();
    }

    public void addItem(GroceryItem item) {
        items.add(item);
        System.out.println(item.getName() + " added to basket.");
    }

    public void clearBasket() {
        items.clear();
        System.out.println("Basket cleared.");
    }

    public List<GroceryItem> getItems() {
        return items;
    }

    public double calculateTotalCost() {
        double totalCost = 0.0;
        for (GroceryItem item : items) {
            totalCost += item.getPrice();
        }
        return totalCost;
    }
}
