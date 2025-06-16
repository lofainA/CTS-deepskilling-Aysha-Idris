public interface Stock {
    public void register(String id, String type);
    public void deregister(String id);
    public void notifyObservers();
}
