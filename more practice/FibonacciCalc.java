import java.util.Scanner;

public class FibonacciCalc {
    public static void main(String[] args) {
        int x;
        int first = 0;
        int second = 1;
        int newNum;

        Scanner s = new Scanner(System.in);
        System.out.printf("Enter a positive integer: ");
        x = s.nextInt();

        if (x == 0){
            System.out.printf("%d ",first);
        } else if (x == 1){
            System.out.printf("%d  %d", first, second);
        } else if (x > 1){
            System.out.printf("Your fibonacci series is  %d  %d  ",first,second);
            for (int i = 2; i<x+1; i++){
                newNum = first + second;
                System.out.printf("%d  ",newNum);
                first = second;
                second = newNum;
            }
        } else {
            System.out.println("Run the program again and type in a +ve integer!");
        }

    }
}
