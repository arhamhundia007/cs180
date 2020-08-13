import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.printf("Enter a word: ");
        String word = s.nextLine();
        int wordLength = word.length()-1;
        String finalword = ReverseString(word, wordLength);

        if (word.equals(finalword)){
            System.out.printf("The word %s is a palindrome", word);
        } else {
            System.out.printf("The word %s is not a palindrome because its reverse is %s ", word, finalword);
        }


    }
    private static String ReverseString(String x, int length) {
        String word = x;
        String reverse = "";
        int i = length;
        while (i >= 0){
            reverse = reverse + word.charAt(i);
            i = i - 1;
        }
        return reverse;
    }
}
