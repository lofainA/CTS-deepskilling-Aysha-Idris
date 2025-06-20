import java.util.Scanner;

public class TestStrategy {
    public static void main(String[] args) {
        PaymentContext pc = new PaymentContext();
        Scanner sc = new Scanner(System.in);

        boolean paymentSet = false;
        do {
            System.out.println("Enter mode of Payment:\n1. PayPal\n2. Credit card");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    pc.setPaymentStrategy(new PayPalPayment());
                    paymentSet = true;
                    break;
                case 2:
                    pc.setPaymentStrategy(new CreditCardPayment());
                    paymentSet = true;
                    break;
                case 3:
                    System.out.println("Please select a valid payment method.");
                    break;
            }
        } while(!paymentSet);

        pc.getUserDetails();

        boolean payAgain = false;
        do {
            System.out.println("Enter amount to pay: ");
            double amount = sc.nextDouble();

            if (pc.pay(amount)) {
                System.out.println("Payment complete!");
            } else {
                System.out.println("Payment failed.");
            }

            System.out.println("Continue with another payment? (Y/N)");
            char temp = sc.next().charAt(0);
            payAgain = temp == 'Y' || temp == 'y';
        } while(payAgain);
    }
}
