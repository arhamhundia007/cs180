import static org.junit.Assert.*;
import org.junit.*;

/**
 * CS18000 Fall 2018
 *
 * Practice Exam 1
 *
 * Test cases for Vehicle
 *
 * @author Jonathan Grider, jagrider@purdue.edu
 * @version 09/23/2018
 */
public class VehicleTest {

    @Test
    public void testConstructorMotorcycle() {
        Vehicle v = new Vehicle(2, 10);
        String message = "Make sure you are instantiating the class correctly in your constructor!";
        assertEquals(message, 2, v.getNumSeats());
        assertEquals(message, 10, v.getGasCapacity());
        assertEquals(message, 2, v.getNumWheels());
    }

    @Test
    public void testConstructorSedan() {
        Vehicle v = new Vehicle(4, 18);
        String message = "Make sure you are instantiating the class correctly in your constructor!";
        assertEquals(message, 4, v.getNumSeats());
        assertEquals(message, 18, v.getGasCapacity());
        assertEquals(message, 4, v.getNumWheels());
    }

    @Test
    public void testConstructorSUV() {
        Vehicle v = new Vehicle(4, 25);
        String message = "Make sure you are instantiating the class correctly in your constructor!";
        assertEquals(message, 7, v.getNumSeats());
        assertEquals(message, 25, v.getGasCapacity());
        assertEquals(message, 4, v.getNumWheels());
    }


    @Test
    public void testSetters() {
        Vehicle v = new Vehicle(4, 25);
        String message = "Make sure you are correctly updating the values in your setters";

        v.setGasCapacity(100);  // Seems legit. :troll:
        v.setNumSeats(2);
        v.setNumWheels(2);

        assertEquals(message, 2, v.getNumSeats());
        assertEquals(message, 100, v.getGasCapacity());
        assertEquals(message, 2, v.getNumWheels());
    }

    @Test
    public void testCanHold() {
        Vehicle v = new Vehicle(4, 25);
        String tooMany = "Make sure you are correctly returning false when too many people try to enter the car!";
        String justRight = "Make sure you are correctly returning true when people can get into the car!";
        assertEquals(tooMany, false, v.canHoldPassengers(8));  // It's doable, right?
        assertEquals(tooMany, true, v.canHoldPassengers(4));
    }

}