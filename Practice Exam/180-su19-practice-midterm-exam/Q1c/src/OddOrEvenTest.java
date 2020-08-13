import static org.junit.Assert.*;
import org.junit.*;

/**
 * CS18000 Fall 2018
 *
 * Practice Exam 1
 *
 * Test cases for OddOrEven
 *
 * @author Jonathan Grider, jagrider@purdue.edu
 * @version 09/23/2018
 */
public class OddOrEvenTest {
    OddOrEven o;

    @Before
    public void setup() {
        o = new OddOrEven();
    }

    @Test
    public void testOddNumber() {
        String message1 = "Make sure you are correctly returning true if a number is odd!";
        assertEquals(message1, true, o.isOdd(7));
    }

    @Test
    public void testEvenNumber() {
        String message2 = "Make sure you are correctly returning false if a number is even!";
        assertEquals(message2, false, o.isOdd(6));
    }

    @Test
    public void testOddNumberSum() {
        String message1 = "Make sure you are correctly returning true if a number is odd!";
        assertEquals(message1, true, o.isOdd(7, 6));
    }

    @Test
    public void testEvenNumberSum() {
        String message2 = "Make sure you are correctly returning false if a number is even!";
        assertEquals(message2, false, o.isOdd(7, 7));
    }

}
