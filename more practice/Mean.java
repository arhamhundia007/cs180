import java.util.Scanner;
/*
 * Mean Calculator
 *
 * Takes numbers till the user wishes to input and then gives an output.
 *
 * @author Arham Hundia, lab04
 *
 * @version 25 June, 2019
 *
 */
public class Mean {
    public static void main(String[] args) {
        System.out.println("Welcome to the Mean and Range Calculator!");

        Scanner s = new Scanner(System.in);
        double number = 0;
        double sum = 0;
        int num = 0;
        double high = -999999999999999999999999999999999.0;
        double low = 99999999999999999999999999999999999.0;
        double mean;
        double range;
        boolean isDigit = true;

        String decision;
        do {
            boolean isCorrect = false;
            decision = "";

            do {
                System.out.print("Please enter your number: ");
                if (s.hasNextDouble()) {
                    number = s.nextDouble();
                    isDigit = true;

                } else{
                    System.out.println("Numbers only!");
                    isDigit = false;
                    s.next();
                }
            } while (!(isDigit)); //end loop

            if (number > high){
                high = number;
            }
            if (number < low){
                low = number;
            }
            sum = sum + number;
            num = num + 1;


            System.out.print("Do you wish to enter another number?(y/n): ");
            s.nextLine();
            decision = s.nextLine();
            decision = decision.toLowerCase();

            do {
                    if (decision.equals("y")) {
                        decision = "y";
                        isCorrect = true;
                    } else if (decision.equals("n")) {
                        decision = "n";
                        isCorrect = true;
                    } else {
                        System.out.println("Invalid Option.");
                        System.out.print("Do you wish to enter another number?(y/n): ");
                        decision = s.nextLine();
                    }
            } while (!(isCorrect)) ; //end loop



        } while (decision.equals("y")); //end loop
        System.out.println("############################################");

        mean = sum / num;
        range = high - low;

        System.out.printf("Sum: %.2f\n", sum);
        System.out.printf("Num: %d\n", num);
        System.out.printf("Mean: %.2f\n", mean);
        System.out.printf("Range: %.2f\n", range);
        System.out.println("Thank you for using the Mean and Range Calculator!");
    }
}
