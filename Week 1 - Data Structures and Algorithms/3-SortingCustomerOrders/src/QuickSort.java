public class QuickSort implements Sort {
    @Override
    public void sort(Order[] orders) {
        quickSort(orders, 0, orders.length - 1);
    }

    public static void quickSort(Order[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(Order[] arr, int low, int high) {
        double pivot = arr[high].getTotalPrice();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].getTotalPrice() < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(Order[] arr, int i, int j) {
        Order temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
