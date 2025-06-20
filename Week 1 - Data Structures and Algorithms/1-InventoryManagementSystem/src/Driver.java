import inventory.Inventory;
import inventory.InventoryManager;
import inventory.Product;

public class Driver {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager(new Inventory());
        manager.displayProduct(manager.getProductById(103));

        manager.addProduct("Loofa", 105, 120);
        manager.displayProduct(manager.getProductById(112));

        manager.updateProduct(105);
        manager.displayProduct(manager.getProductById(105));
    }
}