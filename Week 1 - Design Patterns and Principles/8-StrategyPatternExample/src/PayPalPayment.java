import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PayPalPayment implements PaymentStrategy {
    private final Scanner sc = new Scanner(System.in);
    private static Map<String, String> DATABASE = new HashMap<>();
    private String email;
    private String password;
    private boolean signedIn;

    private void setSignedIn(boolean signedIn) {
        this.signedIn = signedIn;
    }

    static {
        DATABASE.put("sohaib123", "mhmd.sohaib968@db.com");
        DATABASE.put("green21", "lettuce34@kac.com");
        DATABASE.put("broccoli69", "broc.lesner333@wwe.com");
    }

    @Override
    public void getUserDetails() {
        while(!signedIn){
            System.out.println("Enter your email");
            email = sc.nextLine();

            System.out.println("Enter your password: ");
            password = sc.nextLine();

            if(verify()) {
                System.out.println("User verification success!");
            } else {
                System.out.println("Invalid credentials, access denied.");
                System.out.println("Retry..");
                getUserDetails();
            }
        }
    }

    @Override
    public boolean pay(double amount) {
        if(signedIn) {
            System.out.println("Paying Rs." + amount + " using Paypal");
            return true;
        } else {
            return false;
        }
    }

    private boolean verify() {
        setSignedIn(email.equals(DATABASE.get(password)));
        return signedIn;
    }
}
