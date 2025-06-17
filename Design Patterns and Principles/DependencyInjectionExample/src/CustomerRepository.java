import java.util.ArrayList;

public interface CustomerRepository {
    static ArrayList<Customer> customers = new ArrayList<>();

    public Customer findCustomerById(int id);
    public void addCustomer(String name, String address, long phone);
}
