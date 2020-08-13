import java.util.Scanner;


public class SleepIn {
    public static void main(String[] args) {
        boolean weekDay = false;
        boolean vacation = false;

        Scanner s = new Scanner(System.in);

        System.out.printf("Enter whether today is a weekday in Yes or No: ");
        String temp1 = s.next();
        System.out.printf("Enter whether your vacations are going on in Yes or No: ");
        String temp2 = s.next();

        temp1 = temp1.toUpperCase();
        temp2= temp2.toUpperCase();

        if (temp1.equals("YES")) {
            weekDay = true;
        } else if (temp1.equals("NO")) {
            weekDay = false;
        } else {
            System.out.printf("Enter correctly whether today is a weekday in Yes or No: ");
            temp1 = s.next();
        }

        if (temp2.equals("YES")) {
            vacation = true;
        } else if (temp2.equals("NO")) {
            vacation = false;
        } else {
            System.out.printf("Enter whether your vacations are going on in Yes or No: ");
            temp2 = s.next();
        }

        if (weekDay == true && vacation == false) {
            System.out.println(" Can't sleep");
        } else {
            System.out.println("Sleep In");
        }


    }
}



