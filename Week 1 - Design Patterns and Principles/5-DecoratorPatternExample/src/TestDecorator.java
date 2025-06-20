import java.util.Scanner;

public class TestDecorator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Notification to send: ");
        String notif = sc.nextLine();

        NotifierDecorator notifier = new SlackNotifierDecorator(new SMSNotifierDecorator(new EmailNotifier()));

        notifier.send(notif);
    }
}
