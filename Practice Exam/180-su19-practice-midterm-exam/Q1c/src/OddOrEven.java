/**
 * This class contains simple mathematical helper functions.
 */
public class OddOrEven {
    /**
     * This method returns true if the given integer is odd, false otherwise.
     */
    public boolean isOdd(int num) {
        if (num % 2 == 0){
            return false;
        } else {
            return true;
        }
    }

    /**
     * This method returns true if the sum of given integer is odd, false otherwise.
     */
    public boolean isOdd(int num1, int num2) {
        int sum = num1 + num2;
        if (sum % 2 == 0) {
            return false;
        } else {
            return true;
        }
    }
}