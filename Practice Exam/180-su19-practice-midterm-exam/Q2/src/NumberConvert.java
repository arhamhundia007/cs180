/**
 * This class converts numbers between bases
 */
public class NumberConvert {
    /**
     * This method takes a Decimal (base 10) integer and converts it to a Ternary (base 3) String
     * @param num - a Decimal (base 10) integer
     * @return a String containing the Ternary (base 3) form of the given number.
     *
     * Examples:
     *      - return "21" when the given number is 7
     *      - return "221" when the given number is 25
     *      - return "11" when the given number is 4
     *      - return "122" when the given number is 17
     */
    public String toTernaryString(int num) {

        int remain;
        int quotient;
        int temp = num;
        String ternary = "";
        if (num == 0 || num == 1 || num == 2){
            ternary = ternary + num;
            return ternary;
        }

        while (temp > 0){
            remain = temp % 3;
            ternary = remain + ternary;
            temp = temp / 3;
        }

        return ternary;
    }
}