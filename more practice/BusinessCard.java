import java.util.Scanner;

/*
 * Business Card
 *
 * Asks a student to enter their details and then gives
 * an output consisting those details.
 *
 * @author Arham Hundia, 04
 *
 * @version June 18,2019
 *
 */

public class BusinessCard {
    public static void main(String[] args){

        //Declaring the required variables with meaningful names
        String name;
        int dob;                            //variable for date of birth
        int age;
        double gpa;
        String major;
        String email;
        final int year = 2019;              //to calculate age from the year 2019

        Scanner s = new Scanner(System.in);

        //Getting the input from the user
        System.out.printf("Enter your Name: ");
        name = s.nextLine();

        System.out.printf("Enter your Year of Birth: ");
        dob = s.nextInt();

        System.out.printf("Enter your GPA: ");
        gpa = s.nextDouble();
        s.nextLine();

        System.out.printf("Enter your Major: ");
        major = s.nextLine();

        System.out.printf("Enter your Email: ");
        email = s.nextLine();

        age = year - dob;     //calculating the age of the user

        //Output after the user has finished inputting
        System.out.println();
        System.out.printf("Name: %9s\n", name);
        System.out.printf("Age: %4d\n", age);
        System.out.printf("GPA: %6.2f\n", gpa);
        System.out.printf("Major: %3s\n", major);
        System.out.printf("Email: %3s\n", email);



    }
}
