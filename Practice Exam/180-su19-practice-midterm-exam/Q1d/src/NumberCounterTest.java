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
public class NumberCounterTest {
    NumberCounter nc;

    @Before
    public void setup() {
        nc = new NumberCounter();
    }

    @Test
    public void testNullString() {
        String message = "Make sure you are returning the correct value when the string is null!";
        assertEquals(message, -1, nc.numDigits(null));
    }

    @Test
    public void testEmptyString() {
        String message = "Make sure you are returning the correct value when the string is empty!";
        assertEquals(message, -1, nc.numDigits(""));
    }

    @Test
    public void testNoNumbersString() {
        String message = "Make sure you are returning the correct value when the string contains no numbers!";
        assertEquals(message, 0, nc.numDigits("TheMitochondriaIsThePowerhouseOfTheCell"));
    }

    @Test
    public void testValidWithNumbers() {
        String message = "Make sure you are returning the correct value when the string contains numbers!";
        assertEquals(message, 12, nc.numDigits("123qwe456rty789asdzxcasdqwe456"));
    }
}
