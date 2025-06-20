package inventory;
import java.util.ArrayList;

public class Inventory {
    protected ArrayList<Product> products = new ArrayList<>();

    {
        products.add(new Product("Shampoo", 200, 250));
        products.add(new Product("Conditioner", 150, 180));
        products.add(new Product("Soap", 50, 75));
        products.add(new Product("Toothbrush", 30, 45));
        products.add(new Product("Toothpaste", 80, 110));
        products.add(new Product("Body Lotion", 250, 300));
        products.add(new Product("Face Wash", 120, 160));
        products.add(new Product("Hair Oil", 180, 220));
        products.add(new Product("Deodorant", 100, 130));
        products.add(new Product("Hand Sanitizer", 60, 90));
        products.add(new Product("Dish Soap", 90, 120));
    }
}
