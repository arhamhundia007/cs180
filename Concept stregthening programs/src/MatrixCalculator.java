import java.util.Scanner;
/**
 * Matrix Calculator
 *
 * Adds and Multiplies two Matrices
 *
 * @author Arham Hundia, lab04
 *
 * @version July 2nd, 2019
 *
 */
public class MatrixCalculator {
    public static void main(String[] args) {
        int [][]firstMatrix;
        int [][]secondMatrix;
        int row1;
        int row2;
        int column1;
        int column2;
        int [][]resultAddMatrix;
        int [][]resultMultMatrix;
        int length;
        int counter = 0;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the size of the first matrix (format row x col)");
        System.out.println();

        System.out.println("Enter row ");

        while (!s.hasNextInt()){
            System.out.println("Enter row ");
            s.next();
        }
        row1 = s.nextInt();

        System.out.println("Enter column ");
        while (!s.hasNextInt()){
            System.out.println("Enter column ");
            s.next();
        }
        column1 = s.nextInt();
        firstMatrix = new int[row1][column1];

        System.out.println();

        for (int i = 0; i < row1; i++){
            for (int j = 0; j < column1; j++){
                System.out.printf("Enter the number for row %d and column %d\n",i,j);
                firstMatrix[i][j] = s.nextInt();
            }
        }

        System.out.println();

        System.out.println("Matrix 1 is:");
        for (int i = 0; i < row1; i++){
            for (int j = 0; j < column1; j++){
                System.out.print(firstMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("Enter the size of the second matrix (format row x col)");
        System.out.println();
        System.out.println("Enter row ");
        while (!s.hasNextInt()){
            System.out.println("Enter row ");
            s.next();
        }
        row2 = s.nextInt();

        System.out.println("Enter column ");
        while (!s.hasNextInt()){
            System.out.println("Enter column ");
            s.next();
        }
        column2 = s.nextInt();
        secondMatrix = new int[row2][column2];

        System.out.println();

        for (int i = 0; i < row2; i++){
            for (int j = 0; j < column2; j++){
                System.out.printf("Enter the number for row %d and column %d\n",i,j);
                secondMatrix[i][j] = s.nextInt();
            }
        }

        System.out.println();

        System.out.println("Matrix 2 is:");
        for (int i = 0; i < row2; i++){
            for (int j = 0; j < column2; j++){
                System.out.print(secondMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        if (row1 == row2 && column1 == column2){
            resultAddMatrix = new int[row1][column1];
            for (int i = 0; i < row1; i++){
                for (int j = 0; j < column1; j++){
                    resultAddMatrix[i][j] = firstMatrix[i][j] + secondMatrix[i][j];
                }
            }
            System.out.println("Result after addition");
            for (int i = 0; i < row1; i++){
                for (int j = 0; j < column1; j++){
                    System.out.print(resultAddMatrix[i][j]+" ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Matrices size are not the same!");
            System.out.println();
        }
        System.out.println();
        if (column1 == row2){

            length = firstMatrix.length + firstMatrix[0].length;
            resultMultMatrix = new int[row1][column2];
            for (int i = 0; i < row1; i++){
                for (int j = 0; j < column2; j++){
                    for (int y = 0; y < row2; y++) {
                        counter = counter + (firstMatrix[i][y] * secondMatrix[y][j]);
                    }
                    resultMultMatrix[i][j] = counter;
                    counter = 0;
                }

            }
            System.out.println("Result after multiplication");
            for (int i = 0; i < row1; i++){
                for (int j = 0; j < column2; j++){
                    System.out.print(resultMultMatrix[i][j] + " ");
                }
                System.out.println();
            }
        } else{
            System.out.println("Matrix size doesn't fit requirement!");
        }
    }
}
