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
            "\033[0;1mId: \033[0;0m" + productId +
            ", \033[0;1mName: \033[0;0m" + productName +
            ", \033[0;1mCategory: \033[0;0m" + category +
            "\n---------------------"
        );
    }
}