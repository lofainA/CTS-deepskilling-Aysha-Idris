import org.junit.Test;
import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public void testIsAdult() {
        Person p = new Person("Alice", 20);
        assertTrue(p.isAdult());
    }

    @Test
    public void testGreet() {
        Person p = new Person("Bob", 15);
        assertEquals("Hello, my name is Bob", p.greet());
    }
}
