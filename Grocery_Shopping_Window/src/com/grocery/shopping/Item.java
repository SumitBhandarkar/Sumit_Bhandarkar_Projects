package com.grocery.shopping;

public class Item {
    private String name;
    private double price;
    private String unit;

    public Item(String name, double price, String unit) {
        this.name = name;
        this.price = price;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getUnit() {
        return unit;
    }

    @Override
    public String toString() {
        return name + " - " + price + " rs/" + unit;
    }
}
