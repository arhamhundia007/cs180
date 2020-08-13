import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * CS18000 Fall 2018
 *
 * Practice Exam 1
 *
 * Test cases for NumberConvert
 *
 * @author Varun Vasudevan
 */
public class StringManipulateTest {
    private static StringManipulate sm;

    @BeforeClass
    public static void setUp() {
        sm = new StringManipulate();
    }

    @Test(timeout = 100)
    public void testEncodeNull() {
        String inputString = null;
        String message = "encode(): check when input is null";
        String expected = null;
        String actual = sm.encode(inputString);
        assertEquals(message, expected, actual);
    }

    @Test(timeout = 100)
    public void testEncodeEmpty() {
        String inputString = "";
        String message = "encode(): check when input is empty";
        String expected = "";
        String actual = sm.encode(inputString);
        assertEquals(message, expected, actual);
    }

    @Test(timeout = 100)
    public void testEncodeConsecutiveTarget1() {
        String inputString = "Computer accuracy";
        String message = "encode(): check when input has consecutive occurences of target";
        String expected = "C9c0c3c1";
        String actual = sm.encode(inputString);
        assertEquals(message, expected, actual);
    }

    @Test(timeout = 100)
    public void testEncodeEndsInTarget1() {
        String inputString = "Good programming";
        String message = "encode(): check when input ends in target";
        String expected = "G7g6g";
        String actual = sm.encode(inputString);
        assertEquals(message, expected, actual);
    }

    @Test(timeout = 100)
    public void testEncodeSimple1() {
        String inputString = "My name is Don";
        String message = "encode(): be sure to follow the rules for encoding given in the description";
        String expected = "M4m8";
        String actual = sm.encode(inputString);
        assertEquals(message, expected, actual);
    }

}