/**
 * This class manipulates Strings.
 */
public class StringManipulate {
    /**
     * The encode method takes a string as input and returns its encoded form. We will
     * refer to the first character of the string as the target. To encode the string,
     * we keep each occurrence of the target (ignoring case for alpha characters) and
     * replace all other characters with the number of characters that follow the
     * current target, up to the next target or the end of the string, repeating until
     * the end of the string is reached.
     *
     * Consider the string "My name is Miya". The first character in this string is 'M'.
     * Ignoring case, the target 'M' occurs thrice in this string at indices 0, 5, and 11.
     * Keeping the occurrences of the target and replacing the count of characters following
     * each target, the encoded string to return is "M4m5M3".
     *
     * @param inp input string
     * @return
     * 		- an empty string when inp is empty
     * 		- null when inp is null
     *
     * Examples
     * 		- return "M4m8" when inp is "My name is Don"
     *		- return "C9c0c3c1" when inp is "Computer accuracy"
     *	      Note: In this example, there are two consecutive occurrences of the target
     *		- return "G7g6g" when inp is "Good programming"
     *	 	  Note: In this example, string ends in the target character.
     * 		- return "33735" when inp is "3 countries signed a treaty on August 3 2015"
     * 		- return "I9i3I5" when inp is "I don't think I can."
     * 		- return "P12" when inp is "Peter Samsung"
     */
    public String encode(String inp) {
        if (inp == null){
            return null;
        } else if (inp.equals("")) {
            return "";
        }

        int counter = 0;
        int length = inp.length();
        String first = inp.substring(0,1);
        char checker = inp.charAt(0);
        String encode = first + "";
        int indexOf = 0;
        String checker2 = inp.charAt(0)+ "" ;
        checker2 = checker2.toLowerCase();
        String temp;
        for (int i = 1; i < length; i++){
            temp = inp.charAt(i)+ "";
             if (checker == inp.charAt(i)){
                indexOf = i;
                encode = encode + counter + checker;
                counter = 0;
            } else if(checker2.equals(temp)){
                indexOf = i;
                encode = encode + counter + checker2;
                counter = 0;
            } else {
                 counter += 1;
             }
        }
        int finalch = length-1 - indexOf;
        if (finalch != 0){
            encode = encode + finalch;
        }

        return encode;
    }
}