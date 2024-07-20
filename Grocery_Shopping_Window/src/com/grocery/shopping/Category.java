package com.grocery.shopping;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    private List<Item> items;

    public Category(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name + ":\n");
        for (int i = 0; i < items.size(); i++) {
            sb.append((i + 1) + ". " + items.get(i) + "\n");
        }
        return sb.toString();
    }
}
