import java.util.Scanner;

public class TestLogger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        Logger lg = Logger.getInstance();
        do {
            System.out.println("1. Increase count\n2. Decrease Count\n3. New Logger\n4. Exit\n");
            n = sc.nextInt();

            switch (n) {
                case 1:
                    lg.increase();
                    break;
                case 2:
                    lg.decrease();
                    break;
                case 3:
                    lg = Logger.getInstance();
                    break;
                case 4:
                    System.out.println("Terminating Program....");
                    return;
            }

        } while(n != 4);
    }
}
