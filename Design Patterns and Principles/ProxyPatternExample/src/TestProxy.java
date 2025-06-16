public class TestProxy {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("1");
        Image image2 = new ProxyImage("1");

        long naive = test(image1);
        long smart = test(image2);
        System.out.println("Time saved by caching: " + (naive - smart) + " ms");
    }

    public static long test(Image image){
        long startTime = System.currentTimeMillis();
        image.display();
        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("Ellapsed Time: " + elapsedTime + " ms\n");
        return elapsedTime;
    }
}
