import org.junit.*;

import static org.junit.Assert.*;

public class PersonLifeCycleTest {

    private Person person;

    @Before
    public void setUp() {
        person = new Person("Mark", 30);
    }

    @After
    public void tearDown() {
        person = null;
    }

    @Test
    public void testIsAdult_AAA() {
        boolean result = person.isAdult();
        assertTrue(result);
    }

    @Test
    public void testGreet_AAA() {
        String greeting = person.greet();
        assertEquals("Hello, my name is Mark", greeting);
    }
}
