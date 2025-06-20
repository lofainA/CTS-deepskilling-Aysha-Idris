package inventory;

import java.util.Scanner;

public class InventoryManager {
    private final Inventory inventory;

    public InventoryManager (Inventory inventory) {
        this.inventory = inventory;
    }

    public void addProduct(String name, int quantity, double price) {
        inventory.products.add(new Product(name, quantity, price));
        System.out.println("Added new product\n" + inventory.products.getLast().productName +
                "\nID: " + inventory.products.getLast().productId +
                "\n-----------------------------------");
    }

    public void displayProducts() {
        for(int i = 0; i < inventory.products.size(); i++) {
            Product curr = inventory.products.get(i);
            System.out.println(
                    "\nProduct name: " + curr.productName +
                    "\nProduct Id: " + curr.productId +
                    "\nPrice: Rs." + curr.price +
                    "\nQuantity: " + curr.quantity + " units" +
                    "\n-----------------------------------"
            );
        }
    }

    public void displayProduct(Product p) {
        System.out.println(
            "Product name: " + p.productName +
            "\nProduct Id: " + p.productId +
            "\nPrice: Rs." + p.price +
            "\nQuantity: " + p.quantity + " units" +
            "\n-----------------------------------"
        );
    }

    public Product getProductById(int id) {
        for(int i = 0; i < inventory.products.size(); i++) {
            if(inventory.products.get(i).productId == id)
                return inventory.products.get(i);
        }
        return null;
    }

    public void updateProduct(int id) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Parameter to change in " + getProductById(id).productName + "\n1. Name   2. Price  3. Quantity");
        int n = sc.nextInt();

        switch (n) {
            case 1:
                System.out.print("Name to change to: ");
                String name = sc.nextLine();
                changeName(this.getProductById(id),name);
                break;

            case 2:
                System.out.print("New Price: ");
                double price = sc.nextDouble();
                changePrice(this.getProductById(id),price);
                break;

            case 3:
                System.out.print("Updated quantity: ");
                int quantity = sc.nextInt();
                updateQuantity(this.getProductById(id),quantity);
                break;
        }
    }

    private void changeName(Product prod, String name) {
        String old = prod.productName;
        prod.productName = name;
        System.out.println("Name changed: " + old + " --> " + name);
        System.out.println("-----------------------------------");
    }

    private void changePrice(Product prod, double price) {
        double old = prod.price;
        prod.price = price;
        System.out.println("Price changed: Rs." + old + " --> Rs." + price);
        System.out.println("-----------------------------------");
    }

    private void updateQuantity(Product prod, int quant) {
        int old = prod.quantity;
        prod.quantity = quant;
        System.out.println("Quantity updated: " + old + "units --> " + quant + " units");
        System.out.println("-----------------------------------");
    }
}