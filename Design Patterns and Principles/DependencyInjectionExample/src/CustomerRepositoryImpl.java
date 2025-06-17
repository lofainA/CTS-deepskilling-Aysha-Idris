import java.util.ArrayList;

public class CustomerRepositoryImpl implements CustomerRepository {
    static {
        customers.add(new Customer(101, "Jake Gyllenhaal", "21, Lakeview Street", 9828737181L));
        customers.add(new Customer(102, "Emma Watson", "15, Maple Avenue", 9876543210L));
        customers.add(new Customer(103, "Robert Downey", "42, Stark Tower", 9123456789L));
        customers.add(new Customer(104, "Scarlett Johansson", "88, Ocean Drive", 9988776655L));
        customers.add(new Customer(105, "Chris Evans", "12, Elm Street", 9845612378L));
        customers.add(new Customer(106, "Zendaya Coleman", "77, Riverbank Road", 9764312890L));
        customers.add(new Customer(107, "Tom Holland", "30, Queens Boulevard", 9911223344L));
        customers.add(new Customer(108, "Brie Larson", "60, Pine Crescent", 9898989898L));
        customers.add(new Customer(109, "Benedict Cumberbatch", "101, Baker Street", 9732468101L));
        customers.add(new Customer(110, "Gal Gadot", "5, Paradise Lane", 9870011223L));

    }

    @Override
    public Customer findCustomerById(int id) {
        for(int i = 0; i < customers.size(); i++) {
            if(customers.get(i).getId() == id) {
                return customers.get(i);
            }
        }
        return null;
    }

    @Override
    public void addCustomer(String name, String address, long phone) {
        int id = customers.getLast().getId() + 1;
        customers.add(new Customer(id, name, address, phone));
    }
}
