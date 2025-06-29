package excercise3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppenderExample {
    private static final Logger logger = LoggerFactory.getLogger(AppenderExample.class);

    public static void main(String[] args) {
        logger.debug("Debug message: application starting...");
        logger.info("Info message: user logged in");
        logger.warn("Warning message: low disk space");
        logger.error("Error message: exception occurred");
    }
}

