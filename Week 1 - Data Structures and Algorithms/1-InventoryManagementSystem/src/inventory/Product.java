package inventory;
public class Product {

    static private int id = 101;
    public int productId;
    public String productName;
    public int quantity;
    public double price;
    
    Product(String productName, int quantity, double price) {
        this.productId = id++;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }
}
