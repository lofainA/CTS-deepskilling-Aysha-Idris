import java.util.Arrays;

public class Catalogue {
    static Product[] products = new Product[100];
    static int pointer = 0;

    static {
        products[0] = new Product("Wireless Mouse", "electronics");
        products[1] = new Product("Yoga Mat", "fitness");
        products[2] = new Product("LED Desk Lamp", "home decor");
        products[3] = new Product("Bluetooth Speaker", "electronics");
        products[4] = new Product("Notebook", "stationery");
        products[5] = new Product("Reusable Water Bottle", "travel");
        products[6] = new Product("Scented Candle", "home Decor");
        products[7] = new Product("Electric Kettle", "kitchen appliances");
        products[8] = new Product("Running Shoes", "footwear");
        products[9] = new Product("Travel Backpack", "travel");
        products[10] = new Product("Noise Cancelling Headphones", "electronics");
        pointer = 10;
    }

    public static int size() {
        return pointer + 1;
    }

    public static void sort() {
        Arrays.sort(products);
    }
}
