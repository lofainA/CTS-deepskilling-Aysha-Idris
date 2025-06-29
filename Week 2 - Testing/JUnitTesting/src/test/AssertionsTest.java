import org.junit.Test;
import static org.junit.Assert.*;

public class AssertionsTest {

    @Test
    public void testAssertions() {
        assertEquals("Test equality", 10, 5 + 5);
        assertTrue("Age check", new Person("John", 25).isAdult());
        assertFalse("Minor check", new Person("Lily", 12).isAdult());
        assertNull("Should be null", null);
        assertNotNull("Object must exist", new Person("Eva", 22));
    }
}
