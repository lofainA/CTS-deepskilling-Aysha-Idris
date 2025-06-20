public class CreditCard {
    private double balance;
    private String number;
    private String cvv;

    public CreditCard(String number, String cvv) {
        this.number = number;
        this.cvv = cvv;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
