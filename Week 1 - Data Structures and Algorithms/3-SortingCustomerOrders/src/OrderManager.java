import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class OrderManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Order[] orders = {
            new Order("Rainbow Confetti Cupcakes x6", 660),
            new Order("Biscoff mousse", 300),
            new Order("Caramel filled Donut", 250),
            new Order("Triple Chocolate Cake", 760),
            new Order("Red Velvet Cheesecake Slice", 520),
            new Order("Classic Tiramisu Cup", 390),
            new Order("Mini Blueberry Tarts x3", 340),
            new Order("Salted Caramel Brownies x4", 480),
            new Order("Peanut Butter Fudge Bar", 270)
        };

        System.out.println("Choose the sorting algorithm:\n1.Bubble Sort\n2.Quick Sort");
        int opt = sc.nextInt();

        Sort strategy = opt == 1 ? new BubbleSort() : new QuickSort();
        strategy.sort(orders);

        for(int i = 0; i < orders.length; i++) {
            orders[i].display();
        }
    }
}
