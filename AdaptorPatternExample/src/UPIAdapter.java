public class UPIAdapter implements PaymentProcessor {
    private UPIGateway ug;

    public UPIAdapter(UPIGateway ug) {
        this.ug = ug;
    }

    @Override
    public void processPayment(double amount) {
        ug.sendMoney(amount);
        System.out.println("Payment processed");
    }
}
