import org.junit.*;
import static org.junit.Assert.*;

/**
 * CS18000 Fall 2018
 *
 * Practice Exam 1
 *
 * Test cases for ArrayAdder
 *
 * @author Jonathan Grider, jagrider@purdue.edu
 * @version 09/23/2018
 */
public class ArrayAdderTest {

    private ArrayAdder aa;

    @Before
    public void setup() {
        aa = new ArrayAdder();
    }

    @Test
    public void testNullArrays() {
        String message = "Ensure you are returning the correct value when the array is null!";
        assertEquals(message, -1, aa.addEnds(null));
        assertEquals(message, -1, aa.addMinMax(null));
    }

    @Test
    public void testEmptyArrays() {
        String message = "Ensure you are returning the correct value when the array is empty!";
        assertEquals(message, -1, aa.addEnds(new int[0]));
        assertEquals(message, -1, aa.addMinMax(new int[0]));
    }

    @Test
    public void testSingleArrays() {
        String message = "Ensure you are returning the correct value when the array has one element!";
        int[] arr = new int[]{76};
        assertEquals(message, 76, aa.addEnds(arr));
        assertEquals(message, 76, aa.addMinMax(arr));
    }

    @Test
    public void testEndsBigArray() {
        String message = "Ensure you are returning the correct value when adding the ends of an array!";
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        assertEquals(message, 1, aa.addEnds(arr));
    }

    @Test
    public void testEndsSmallArray() {
        String message = "Ensure you are returning the correct value when adding the ends of an array!";
        int[] arr = new int[]{99, 88, 77, 66, 55, 44};
        assertEquals(message, 143, aa.addEnds(arr));
    }

    @Test
    public void testMinMaxBigArray() {
        String message = "Ensure you are correctly adding the smallest and largest values of the array!";
        int[] arr = new int[]{-99, 100, 15, 1, 2, 3, 4, 5, 55, 66, 1234556, 1234566, -12345};
        assertEquals(message, 1222221, aa.addMinMax(arr));
    }

    @Test
    public void testMinMaxSmallArray() {
        String message = "Ensure you are correctly adding the smallest and largest values of the array!";
        int[] arr = new int[]{-5, -4, -3, 0, 3, 4, 5};
        assertEquals(message, 0, aa.addMinMax(arr));
    }

}
