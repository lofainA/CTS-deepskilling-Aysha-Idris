public class PaymentContext {
    PaymentStrategy strategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void getUserDetails() {
        if(strategy == null) {
            System.out.println("No payment method selected.");
        } else {
            strategy.getUserDetails();
        }
    }

    public boolean pay(double amount) {
        if(strategy == null) {
            System.out.println("No payment method selected.");
            return false;
        }
        return strategy.pay(amount);
    }
}
