package inventory;
public class InventoryManager {
    private Inventory inventory;

    InventoryManager (Inventory inventory) {
        this.inventory = inventory;
    }

    void addProduct(String name, int quantity, double price) {
        inventory.products.add(new Product(name, quantity, price));
        System.out.println("Added new product ID: " + inventory.products.getLast().productId);
    }

    void displayProducts() {
        for(int i = 0; i < inventory.products.size(); i++) {
            System.out.println("");          
        }
    }

    public Product getProductById(int id) {
        for(int i = 0; i < inventory.products.size(); i++) {
            if(inventory.products.get(i).productId == id) {
                return inventory.products.get(i);
            }
        }
        return null;
    }

    void updateProduct(int id) {
        
    }
}