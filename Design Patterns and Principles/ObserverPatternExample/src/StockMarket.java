import java.util.ArrayList;

public class StockMarket implements Stock {

    ArrayList<Observer> observers = new ArrayList<>();

    @Override
    public void register(String id, String type) {
        if(type.equals("mobile")) {
            observers.add(new MobileApp(id));
        } else if(type.equals("web")) {
            observers.add(new WebApp(id));
        }
    }

    @Override
    public void deregister(String id) {
        for(int i = 0; i < observers.size(); i++) {
            if(observers.get(i).getId().equals(id)) {
                observers.remove(observers.get(i));
                break;
            }
        }
        System.out.println("\nRemoved user " + id + "from subscription.");
    }

    @Override
    public void notifyObservers() {
        System.out.println();
        for(int i = 0; i < observers.size(); i++) {
            observers.get(i).update();
        }
    }
}
