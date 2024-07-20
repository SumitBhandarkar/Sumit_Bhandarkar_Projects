package com.grocery.shopping;

import java.util.*;

public class GroceryShopping {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Category vegetables = new Category("Vegetables");
        vegetables.addItem(new Item("Potato", 15, "kg"));
        vegetables.addItem(new Item("Tomato", 20, "kg"));
        vegetables.addItem(new Item("Gobi (Cauliflower)", 40, "kg"));

        Category freshItems = new Category("Fresh Items");
        freshItems.addItem(new Item("Milk", 60, "L"));
        freshItems.addItem(new Item("Curd", 80, "L"));
        freshItems.addItem(new Item("Buttermilk", 40, "L"));

        Category storeItems = new Category("Store Items");
        storeItems.addItem(new Item("Sugar", 40, "kg"));
        storeItems.addItem(new Item("Salt", 20, "pack"));
        storeItems.addItem(new Item("Oil", 90, "L"));

        List<Category> categories = Arrays.asList(vegetables, freshItems, storeItems);

        Basket basket = new Basket();
        User user = new User("Sumit", 1000);  // Initial wallet balance and user name

        while (true) {
            System.out.println("Categories:");
            for (int i = 0; i < categories.size(); i++) {
                System.out.println((i + 1) + ". " + categories.get(i).getName());
            }
            System.out.println("4. Go to Payment");
            System.out.print("Select a category or go to payment: ");
            int choice = scanner.nextInt();

            if (choice == 4) {
                break;
            }

            if (choice < 1 || choice > categories.size()) {
                System.out.println("Invalid choice, try again.");
                continue;
            }

            Category selectedCategory = categories.get(choice - 1);
            System.out.println(selectedCategory);
            System.out.print("Select an item to add to basket: ");
            int itemChoice = scanner.nextInt();

            if (itemChoice < 1 || itemChoice > selectedCategory.getItems().size()) {
                System.out.println("Invalid choice, try again.");
                continue;
            }

            Item selectedItem = selectedCategory.getItems().get(itemChoice - 1);
            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();
            basket.addItem(selectedItem, quantity);
            System.out.println("Added to basket: " + selectedItem.getName() + " x " + quantity);
        }

        System.out.println(basket);
        System.out.println(user);

        double totalAmount = basket.calculateTotal();
        try {
            if (user.getWallet().deduct(totalAmount)) {
                System.out.println("Payment successful!");
                System.out.println("Here are your items, " + user.getName() + ":");
                System.out.println(basket);
                System.out.println("Have a good day!");
            }
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(user);
    }
}
