package excercise2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLogging {
    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLogging.class);

    public static void main(String[] args) {
        String user = "Aysha";
        int items = 5;
        double price = 1700;

        logger.info("User {} added {} items to cart, total price: ${}", user, items, price);
        logger.warn("Inventory is low for user {}", user);
        logger.error("Checkout failed for user {} with total ${}", user, price);
    }
}

