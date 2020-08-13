import java.sql.SQLOutput;
import java.util.Scanner;

public class SwitchCalc {
    public static void main(String[] args) {

        String menuChoice;

        Scanner s = new Scanner(System.in);

        System.out.println("Choose one of the following option");
        System.out.println("A. Addition");
        System.out.println("B. Subtraction");
        System.out.println("C. Multiplication");
        System.out.println("D. Division");
        System.out.println("E. Remainder");
        System.out.println("F. Exponention");
        System.out.println("G. Exit");

        menuChoice = s.nextLine()
                      .toUpperCase();

        while (!(menuChoice.equals("F"))) {


            switch (menuChoice) {

                case "A": {
                    double appendOne;
                    double appendTwo;
                    double answer;

                    System.out.println();
                    System.out.print("Enter append one: ");

                    while (!(s.hasNextDouble())) {
                        s.nextLine();

                        System.out.println();

                        System.out.println("Error: the specified number is not a number");
                        System.out.println();
                        System.out.print("Enter append one: ");
                    }//end while
                    appendOne = Double.parseDouble(s.nextLine());

                    System.out.print("Enter append two: ");

                    while (!(s.hasNextDouble())) {
                        s.nextLine();

                        System.out.println();

                        System.out.println("Error: the specified number is not a number");
                        System.out.println();
                        System.out.print("Enter append two: ");
                    }//end while
                    appendTwo = Double.parseDouble(s.nextLine());

                    answer = appendOne + appendTwo;

                    System.out.printf("%.2f + %.2f = %.2f\n", appendOne, appendTwo, answer);
                }


                break; //endCase A

                case "B": {
                    double subtract1;
                    double subtract2;
                    double answer;

                    System.out.print("Enter 1st num : ");

                    while (!(s.hasNextDouble())) {
                        s.nextLine();

                        System.out.println();

                        System.out.println("Error: the specified number is not a number");

                        System.out.print("Enter 1st num: ");
                    }//end while

                    subtract1 = Double.parseDouble(s.nextLine());

                    System.out.print("Enter 2nd num: ");

                    while (!(s.hasNextDouble())) {
                        s.nextLine();

                        System.out.println();

                        System.out.println("Error: the specified number is not a number");

                        System.out.print("Enter second num: ");
                    }//end while

                    subtract2 = Double.parseDouble(s.nextLine());

                    answer = subtract1 - subtract2;

                    System.out.printf("%.2f - %.2f = %.2f\n", subtract1, subtract2, answer);

                }//endCase B


                break;



                case "C": {
                    double num1;
                    double num2;
                    double answer;

                    System.out.print("Enter 1st num : ");

                    while (!(s.hasNextDouble())) {
                        s.nextLine();

                        System.out.println();

                        System.out.println("Error: the specified number is not a number");

                        System.out.print("Enter 1st num: ");
                    }//end while

                    num1 = Double.parseDouble(s.nextLine());

                    System.out.print("Enter 2nd num: ");

                    while (!(s.hasNextDouble())) {
                        s.nextLine();

                        System.out.println();

                        System.out.println("Error: the specified number is not a number");

                        System.out.print("Enter second num: ");
                    }//end while

                    num2 = Double.parseDouble(s.nextLine());

                    answer = num1 * num2;

                    System.out.printf("%.2f * %.2f = %.2f\n", num1, num2, answer);
                }//endCase C


                break;


            }//end switch
            System.out.println();
            System.out.println("Choose one of the following option");
            System.out.println("A. Addition");
            System.out.println("B. Subtraction");
            System.out.println("C. Multiplication");
            System.out.println("D. Division");
            System.out.println("E. Remainder");
            System.out.println("F. Exponention");
            System.out.println("G. Exit");
            menuChoice = s.nextLine()
                          .toUpperCase();
        }
    }
}