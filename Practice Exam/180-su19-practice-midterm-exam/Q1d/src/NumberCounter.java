/**
 * This class provides helper methods for strings.
 */
public class NumberCounter {
    /**
     * This method returns the number of digits present in the given String.
     *
     * The String may contain numbers, letters, special characters or spaces.
     *
     * If the String is null or empty, return -1
     *
     * @param str - The String we are searching for digits in
     * @return the number of digits in the String
     */
    public int numDigits(String str) {
        if (str == null){
            return -1;
        } else if (str == ""){
            return -1;
        }
        int counter = 0;

        for (int i = 0; i < str.length(); i++){
            String x = str.charAt(i) + "";
            for (int j = 0; j < 10; j++){
                String checker = j + "";
                if (x.equals(checker)){
                    counter += 1;
                }
            }

        }
        return counter;
    }
}