public class MobileApp implements Observer {
    private String id;

    MobileApp(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void update() {
        System.out.println("Notified mobile user " + id + " regarding updates.");
    }
}
