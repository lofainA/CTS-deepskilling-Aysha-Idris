public class TestAdapter {
    public static void main(String[] args) {
        PaymentProcessor paypal = new PaypalAdapter(new PaypalGateway());
        PaymentProcessor upi = new UPIAdapter(new UPIGateway());

        paypal.processPayment(250);
        upi.processPayment(1900);
    }
}
