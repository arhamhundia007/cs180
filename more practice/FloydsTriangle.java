import java.util.Scanner;
public class FloydsTriangle {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.printf("Enter a Number:");
        int input = s.nextInt();
        int x = 0;

        for (int i = 0; i<input; i++){
            for (int j = 0; j<input; j++){
                if (j<=i){
                    x = x + 1;
                    System.out.printf("%d  ",x);
                } else {
                    continue;
                }

            }
            System.out.println();
        }
    }
}
