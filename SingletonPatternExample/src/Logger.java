public class Logger {
    private static Logger logger = new Logger();

    private int count = 0;

    public void increase() {
        System.out.println("Count: " + ++count);
    }

    public void decrease() {
        System.out.println("Count: " + --count);
    }

    private Logger() {}

    public static Logger getInstance() {
        return logger;
    }
}
