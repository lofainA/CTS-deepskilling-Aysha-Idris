public class TestObserver {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        stockMarket.register("Aysha968", "web");
        stockMarket.register("Abdul07", "mobile");
        stockMarket.register("dk_09", "mobile");
        stockMarket.register("mayfly21", "web");

        stockMarket.notifyObservers();

        stockMarket.deregister("mayfly21");

        stockMarket.notifyObservers();
    }
}
