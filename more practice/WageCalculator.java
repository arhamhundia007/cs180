import java.util.Scanner;


public class WageCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double hourlyWage;
        double hoursWorked;

        System.out.print("INPUT YOUR WAGE");
        hourlyWage = input.nextDouble();
        System.out.print("Input Hours Worked");
        hoursWorked = input.nextDouble();

        double total = hourlyWage * hoursWorked;
        System.out.print(total);
    }
}
