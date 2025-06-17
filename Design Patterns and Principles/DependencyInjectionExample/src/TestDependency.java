public class TestDependency {
    public static void main(String[] args) {
        CustomerRepository repo = new CustomerRepositoryImpl();
        CustomerService cs = new CustomerService(repo);

        cs.getCustomerDetails(106);
        cs.getCustomerDetails(107);
        cs.getCustomerDetails(103);
    }
}
