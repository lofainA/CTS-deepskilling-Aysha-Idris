public class Order {
    private static int idCount = 100;
    private int id;
    private String name;
    private double totalPrice;

    public Order(String name, double totalPrice) {
        this.id = idCount++;
        this.name = name;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void display() {
        System.out.println(
                "Id: " + id + "\tName: " + name + "\tPrice: Rs." + totalPrice
        );
    }
}
