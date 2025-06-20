public class Product {
    static int idCount = 100;
    public int productId;
    public String productName;
    public String category;
    
    public Product(String productName, String category) {
        this.productId = idCount++;
        this.productName = productName;
        this.category = category;
    }

    public void displayDetails() {
        System.out.println(
            "Id: " + productId + 
            "\nName: " + productName +
            "\nCategory: " + category +
            "\n---------------------"
        );
    }
}