public class OrderManager {
    public static void main(String[] args) {

        Order[] orders = Orders.orders;

        System.out.println("Bubble sorting " + orders.length + " items...");
        Sort strategy = new BubbleSort();
        long bubble = test(strategy, orders);

        System.out.println("Quick sorting " + orders.length + " items...");
        strategy = new QuickSort();
        long quick = test(strategy, orders);

        for(int i = 0; i < orders.length; i++) {
            if(orders[i] != null && i > 10) {
                System.out.println("........");
                break;
            }
            orders[i].display();
        }

        System.out.println("\n\033[0;1mTime saved by quick sort: " + (bubble-quick)/ 1_000_000.0 + "/ms\033[0;0m");
    }

    public static long test(Sort strategy, Order[] orders){
        long startTime = System.nanoTime();
        strategy.sort(orders);
        long elapsedTime = System.nanoTime() - startTime;

        System.out.println("Elapsed Time: " + (elapsedTime / 1_000_000.0) + " ms\n");
        return elapsedTime;
    }
}
