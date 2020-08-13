/**
 *
 * The VehicleTest class within this module has compile time errors. This is because the Vehicle
 * class is incomplete. If you complete the Vehicle class correctly, all the compile time
 * errors within VehicleTest will automatically get fixed.
 *
 * This class models a Vehicle. A car can have 2 or 4 wheels, can have 2, 4 or 7 seats and can
 * hold a certain amount of gas (measured in gallons) in it's tank.
 *
 * To complete the class Vehicle:
 *
 * - Create a public Constructor for Vehicle that instantiates the numWheels, gasCapacity and
 *   numSeats instance variables:
 *
 *              public Vehicle(int numWheels, int gasCapacity)
 *
 *              This constructor should instantiate the numSeats variable according to
 *              the following constraints:
 *
 *                  The Vehicle can hold 2 passengers if it has 2 wheels
 *
 *                  The Vehicle can hold 4 passengers if it has 4 wheels and a gasCapacity of
 *                  less than or equal to 20 gallons.
 *
 *                  The Vehicle can hold 7 passengers if it has 4 wheels and a gasCapacity of
 *                  more than 20 gallons.
 *
 *               You may assume that numWheels will always be 2 or 4, and that numGallons will
 *               be greater than 0.
 *
 * - Create public accessors and mutators for each of the instance variables. They should be
 *   named getNumWheels and setNumWheels, and similarly for gasCapacity and numSeats.
 *
 * - Create a method `public boolean canHoldPassengers(int numPersons)` that returns true if
 *   the number of people (numPersons) trying to enter the vehicle will be able to fit. For
 *   example, if a Vehicle has 2 wheels, canHoldPassengers(4) would return false.
 *
 */
public class Vehicle {
    private int numWheels;      // DO NOT REMOVE THIS STATEMENT
    private int gasCapacity;    // DO NOT REMOVE THIS STATEMENT
    private int numSeats;       // DO NOT REMOVE THIS STATEMENT

    // TODO: Implement the Vehicle class
    public Vehicle(int numWheels, int gasCapacity){
        this.numWheels = numWheels;
        this.gasCapacity = gasCapacity;
        if (numWheels == 2){
            this.numSeats = 2;
        } else if (numWheels == 4 && gasCapacity<= 20){
            this.numSeats = 4;
        } else if (numWheels == 4 && gasCapacity > 20){
            this.numSeats = 7;
        }
    }

    public int getNumWheels() {
        return numWheels;
    }

    public void setNumWheels(int numWheels) {
        this.numWheels = numWheels;
    }

    public int getGasCapacity(){
        return gasCapacity;
    }

    public void setGasCapacity(int gasCapacity){
        this.gasCapacity = gasCapacity;
    }

    public int getNumSeats(){
        return numSeats;
    }

    public void setNumSeats(int numSeats){
        this.numSeats = numSeats;
    }

    public boolean canHoldPassengers(int numPersons){
        if (numPersons > numSeats){
            return false;
        } else {
            return true;
        }
    }
}
