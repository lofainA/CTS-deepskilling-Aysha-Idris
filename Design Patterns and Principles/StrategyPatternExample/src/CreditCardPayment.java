import java.util.Scanner;

public class CreditCardPayment implements PaymentStrategy {
    private final Scanner sc = new Scanner(System.in);
    private CreditCard creditCard;
    private boolean creditCardExists = false;

    @Override
    public boolean pay(double amount) {
        if(creditCardExists) {
            if(creditCard.getBalance() > amount) {
                System.out.println("Paying Rs." + amount + " by credit card..");
                creditCard.setBalance(creditCard.getBalance() - amount);
                System.out.println("Your balance: Rs." + creditCard.getBalance() + "\n");
                return true;
            } else {
                System.out.println("Insufficient balance...");
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public void getUserDetails() {
        System.out.println("Enter the card number: ");
        String number = sc.nextLine();
        System.out.print("Enter CVV: ");
        String cvv = sc.next();

        creditCard = new CreditCard(number, cvv);

        creditCard.setBalance(10000);
        creditCardExists = true;
        System.out.println("Credit card read!");
    }
}
