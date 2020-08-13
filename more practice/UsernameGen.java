import java.util.Scanner;

/*
 * Username Generator
 *
 * Takes in the full name and the date of birth of user
 * and produces a username containing the first letter
 * of the name and the last name along with the age.
 *
 * @author Arham Hundia, 04
 *
 * @version June 18,2019
 *
 */

public class UsernameGen {
    public static void main(String[] args){
        String fullName;
        int dob;                              //Date Of Birth
        int age;                              //Stores the calculated age
        final int year = 2019;                //Year from which age has to be calculated
        int spaceChar;                        //Stores the index of the space between the first name and the last name
        String userName;

        Scanner s = new Scanner(System.in);

        System.out.println("What is your full name?");
        fullName = s.nextLine();

        System.out.println("What is your birth year?");
        dob = s.nextInt();

        age = year - dob;

        spaceChar = fullName.indexOf(" ");          //gets the index of the space in the full name

        int length = fullName.length();             //stores the length of the String that is typed into the computer

        userName = fullName.substring(0,1) + fullName.substring(spaceChar+1,length) + age;   //concatenation process
        userName = userName.toLowerCase();          //changes the strings to lowercase

        System.out.printf("Your username is %s", userName);

    }
}
