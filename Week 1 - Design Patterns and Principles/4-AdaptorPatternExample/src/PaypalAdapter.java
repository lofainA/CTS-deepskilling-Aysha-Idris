public class PaypalAdapter implements PaymentProcessor {
    private PaypalGateway pg;

    public PaypalAdapter(PaypalGateway pg) {
        this.pg = pg;
    }

    @Override
    public void processPayment(double amount) {
        pg.makePayment(amount);
    }
}
