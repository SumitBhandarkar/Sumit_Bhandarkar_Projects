package com.grocery.shopping;

import java.util.HashMap;
import java.util.Map;

public class Basket {
    private Map<Item, Integer> items;

    public Basket() {
        this.items = new HashMap<>();
    }

    public void addItem(Item item, int quantity) {
        items.put(item, items.getOrDefault(item, 0) + quantity);
    }

    public double calculateTotal() {
        double total = 0;
        for (Map.Entry<Item, Integer> entry : items.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Your Basket:\n");
        for (Map.Entry<Item, Integer> entry : items.entrySet()) {
            sb.append(entry.getKey().getName() + " x " + entry.getValue() + " = " + (entry.getKey().getPrice() * entry.getValue()) + " rs\n");
        }
        sb.append("Total: " + calculateTotal() + " rs\n");
        return sb.toString();
    }
}
