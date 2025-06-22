public class BubbleSort implements Sort {

    @Override
    public void sort(Order[] order) {
        for(int i = 0; i < order.length; i++) {
            for(int j = 0; j < order.length - i - 1; j++) {
                if(order[j].getTotalPrice() > order[j+1].getTotalPrice()) {
                    double temp = order[j].getTotalPrice();
                    order[j].setTotalPrice(order[j+1].getTotalPrice());
                    order[j+1].setTotalPrice(temp);
                }
            }
        }
    }
}
