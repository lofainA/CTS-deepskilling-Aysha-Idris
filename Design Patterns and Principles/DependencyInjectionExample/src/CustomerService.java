public class CustomerService {
    private CustomerRepository customerRepository;

    // Constructor Injection
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void getCustomerDetails(int id) {
        Customer customer = customerRepository.findCustomerById(id);
        System.out.println("\nName: " + customer.getName() +
                           "\nId: " + customer.getId() +
                           "\nAddress: " + customer.getAddress() +
                           "\nPhone no: " + customer.getPhone());
        System.out.println("---------------------");
    }
}

