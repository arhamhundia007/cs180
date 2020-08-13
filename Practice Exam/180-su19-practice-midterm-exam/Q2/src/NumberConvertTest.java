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
 * @author Jonathan Grider, jagrider@purdue.edu
 * @version 09/23/2018
 */
public class NumberConvertTest {
    private static NumberConvert c;

    @BeforeClass
    public static void setUp() {
        c = new NumberConvert();
    }

    @Test(timeout = 100)
    public void testDecToTernary0() {
        int testNum = 0;
        String message = "decToTernary(): make sure you are handling the zero case correctly";
        String expectedResult = "0";
        String actualResult = c.toTernaryString(testNum);
        assertEquals(message, expectedResult, actualResult);
    }

    @Test(timeout = 100)
    public void testDecToTernary1() {
        int testNum = 1;
        String message = "decToTernary(): your conversion from base 10 to base 3 was incorrect";
        String expectedResult = "1";
        String actualResult = c.toTernaryString(testNum);
        assertEquals(message, expectedResult, actualResult);
    }

    @Test(timeout = 100)
    public void testDecToTernary2() {
        int testNum = 2;
        String message = "decToTernary(): your conversion from base 10 to base 3 was incorrect";
        String expectedResult = "2";
        String actualResult = c.toTernaryString(testNum);
        assertEquals(message, expectedResult, actualResult);
    }

    @Test(timeout = 100)
    public void testDecToTernary3() {
        int testNum = 3;
        String message = "decToTernary(): your conversion from base 10 to base 3 was incorrect";
        String expectedResult = "10";
        String actualResult = c.toTernaryString(testNum);
        assertEquals(message, expectedResult, actualResult);
    }

    @Test(timeout = 100)
    public void testDecToTernary4() {
        int testNum = 4;
        String message = "decToTernary(): your conversion from base 10 to base 3 was incorrect";
        String expectedResult = "11";
        String actualResult = c.toTernaryString(testNum);
        assertEquals(message, expectedResult, actualResult);
    }

    @Test(timeout = 100)
    public void testDecToTernary5() {
        int testNum = 5;
        String message = "decToTernary(): your conversion from base 10 to base 3 was incorrect";
        String expectedResult = "12";
        String actualResult = c.toTernaryString(testNum);
        assertEquals(message, expectedResult, actualResult);
    }

    @Test(timeout = 100)
    public void testDecToTernary6() {
        int testNum = 6;
        String message = "decToTernary(): your conversion from base 10 to base 3 was incorrect";
        String expectedResult = "20";
        String actualResult = c.toTernaryString(testNum);
        assertEquals(message, expectedResult, actualResult);
    }

    @Test(timeout = 100)
    public void testDecToTernary7() {
        int testNum = 7;
        String message = "decToTernary(): your conversion from base 10 to base 3 was incorrect";
        String expectedResult = "21";
        String actualResult = c.toTernaryString(testNum);
        assertEquals(message, expectedResult, actualResult);
    }

    @Test(timeout = 100)
    public void testDecToTernary5000000() {
        int testNum = 5000000;
        String message = "decToTernary(): your conversion from base 10 to base 3 was incorrect";
        String expectedResult = "100102000201012";
        String actualResult = c.toTernaryString(testNum);
        assertEquals(message, expectedResult, actualResult);
    }

    @Test(timeout = 100)
    public void testDecToTernary6000000() {
        int testNum = 6000000;
        String message = "decToTernary(): your conversion from base 10 to base 3 was incorrect";
        String expectedResult = "102021211110020";
        String actualResult = c.toTernaryString(testNum);
        assertEquals(message, expectedResult, actualResult);
    }

    @Test(timeout = 100)
    public void testDecToTernary2147483645() {
        int testNum = 2147483645;
        String message = "decToTernary(): your conversion from base 10 to base 3 was incorrect";
        String expectedResult = "12112122212110202022";
        String actualResult = c.toTernaryString(testNum);
        assertEquals(message, expectedResult, actualResult);
    }

    @Test(timeout = 100)
    public void testDecToTernary2147483646() {
        int testNum = 2147483646;
        String message = "decToTernary(): your conversion from base 10 to base 3 was incorrect";
        String expectedResult = "12112122212110202100";
        String actualResult = c.toTernaryString(testNum);
        assertEquals(message, expectedResult, actualResult);
    }

    @Test(timeout = 100)
    public void testDecToTernary2147483647() {
        int testNum = 2147483647;
        String message = "decToTernary(): your conversion from base 10 to base 3 was incorrect";
        String expectedResult = "12112122212110202101";
        String actualResult = c.toTernaryString(testNum);
        assertEquals(message, expectedResult, actualResult);
    }
}