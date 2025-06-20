public class WebApp implements Observer {
    private String id;

    WebApp(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void update() {
        System.out.println("Notified web user " + id + " regarding updates.");
    }
}
