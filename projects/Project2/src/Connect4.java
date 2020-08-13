import java.util.Scanner;
/*
 * Connect 4
 *
 * A game that shows the winner if they get four colours in a row
 *
 * @author Arham Hundia, 04
 *
 * @version June 7th, 2019
 *
 */
public class Connect4 {
    private static char [][] gameBoard;
    private int moveCounter;
    final private char REDPLAYER = 'O';
    final private char BLACKPLAYER = 'X';

    public Connect4() {
        gameBoard = new char[7][8];
        moveCounter = 1;
        for (int i = 0; i <= 6; i++) {
            for (int j = 0; j <= 7; j++) {
                gameBoard[i][j] = ' ';
            }
        }

    }

    public char [][] getBoard() {

        return gameBoard.clone();

    }

    public int putPiece (int column, char colour){
        int index = -1;
        if (column >= 8 || column <= -1){
            return index;
        }
        int counter = 0;
        for (int i = 6; i > -1; i--){
            if (gameBoard[i][column] == ' '){
                index = i;
                moveCounter += 1;
                break;
            } else if (gameBoard[0][column] != ' ' ){
                counter += 1;
                //ask for the input again
            }
        }

        if (counter >= 7){
            System.out.println("All rows are filled in this column");
        } else {
            gameBoard[index][column] = colour;
            getBoard();
        }

        return index;
    }

    public char checkAlignment(int row, int column){


        char winner = ' ';
        //boolean winning;
        int c = 0;
        char currentChar = ' ';
        if (row == -1){
            c += 1;
        } else {
            currentChar = gameBoard[row][column];
        }
        int winCount;

        //Vertical
        for (int i = 0; i < 8; i++){
            if (c > 0){
                break;
            }
            winCount = 0;
            for (int j = 0; j < 4; j++) {
                winCount = 0;
                for (int x = 1; x < 4; x++){
                    if (gameBoard[j][i] == gameBoard[j + x][i] && gameBoard[j][i] != ' ') {
                        winCount += 1;
                    }
                }

                if (winCount >= 3){
                    winner = currentChar;
                    break;
                }
            }
            if (winCount >= 3){
                winner = currentChar;
                break;
            }
        }

        //Horizontal
        for (int i = 0; i < 7; i++){
            if (c > 0){
                break;
            }
            winCount = 0;
            for (int j = 0; j < 5; j++) {
                winCount = 0;
                for (int x = 1; x < 4; x++){
                    //System.out.printf("%c = %c, ",gameBoard[i][j], gameBoard[i][j+x]);
                    if (gameBoard[i][j] == gameBoard[i][j + x] && gameBoard[i][j] != ' ') {
                        winCount += 1;
                        //System.out.println(winCount);
                    }
                }
                if (winCount >= 3){
                    winner = currentChar;
                    break;
                }
                //System.out.println();

            }
            if (winCount >= 3) {
                break;
            }
        }


        //(/)Diagonal

        int j = 0;
        int count = 0;
        boolean checkColour2 = true;
        while (checkColour2){
            if (row - j >= 0 && column + j < 8){
                if (gameBoard[row][column] == gameBoard[row - j][column + j]) {
                    count += 1;
                    j += 1;
                } else {
                    checkColour2 = false;
                }
            } else{
                checkColour2 = false;
            }
        }
        checkColour2 = true;
        j = 1;
        while (checkColour2){
            if ((row + j < 7 ) && (column - j >= 0)){
                if (gameBoard[row][column] == gameBoard[row + j][column - j]){
                    count += 1;
                    j += 1;
                } else {
                    checkColour2 = false;
                }
            } else {
                checkColour2 = false;
            }
        }

        if (count >= 4){
            winner = currentChar;
        }

        //(\)Diagonal
        int i = 0;
        int count2 = 0;
        boolean checkColour = true;
        while (checkColour){
            if (row + i < 7 && column + i < 8){
                if (gameBoard[row][column] == gameBoard[row + i][column + i]) {
                    count2 += 1;
                    i += 1;
                } else {
                    checkColour = false;
                }
            } else{
                checkColour = false;
            }
        }
        checkColour = true;
        i = 1;
        while (checkColour){
            if (row - i >= 0 && column - i >= 0){
                if (gameBoard[row][column] == gameBoard[row - i][column - i]){
                    count2 += 1;
                    i += 1;
                } else {
                    checkColour = false;
                }
            } else {
                checkColour = false;
            }
        }

        if (count2 >= 4){
            winner = currentChar;
        }

        return winner;
    }

    public void printScreen(){
        for (int i = 0; i <= 7; i++) {
            System.out.printf("     %d", i);
        }
        int index = 0;
        for (int j = 'A'; j<'H'; j++ ){
            System.out.println();
            System.out.println("  -------------------------------------------------");
            System.out.printf("%c |",j);
            for (int k = 0; k<= 7; k++) {
                System.out.printf("  %c  |", gameBoard[index][k]);
            }
            index += 1;
        }
        System.out.println();
        System.out.println("  -------------------------------------------------");


    }

    public void play(){
        char currentPlayer = REDPLAYER;
        boolean win;
        Scanner s = new Scanner(System.in);
        char winner;
        int column = -1;
        int row;
        do {
            printScreen();
            System.out.printf("Current player:'%c'", currentPlayer);
            System.out.println();
            System.out.println("Current Move: " + moveCounter);
            boolean bool = false;
            while (bool == false){
                System.out.printf("Choose a column: ");
                while (!s.hasNextInt()){
                    System.out.printf("Enter a number: ");
                    s.next();
                }
                column = s.nextInt();
                if (column >= 0 && column <= 7) {
                        bool = true;
                } else {
                        System.out.println("Please Enter a number between '0-7'");
                }
            }
            System.out.println();
            row = putPiece(column, currentPlayer);
            winner = checkAlignment(row, column);
            if (winner == REDPLAYER || winner == BLACKPLAYER){
                break;
            } else {
                win = false;
            }

            if (currentPlayer == REDPLAYER){
                currentPlayer = BLACKPLAYER;
            } else if (currentPlayer == BLACKPLAYER){
                currentPlayer = REDPLAYER;
            }

        } while (!win);
        printScreen();
        System.out.printf("!!! After %d moves, the winner is Player '%c' !!!",moveCounter ,winner);
    }


}
