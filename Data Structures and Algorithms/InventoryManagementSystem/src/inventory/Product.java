package inventory;
public class Product {
    static public int productId = 101;
    public String productName;
    public int quantity;
    public double price;
    
    Product(String productName, int quantity, double price) {
        this.productId = productId++;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }
}
