public class ProxyImage implements Image {
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    // Lazy loading implementation
    @Override
    public void display() {
        // Caching implementation
        if(realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}