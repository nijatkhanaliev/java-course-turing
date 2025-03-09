package az.edu.turing.module1.lesson06;


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ShootingGame {

    static Random random = new Random();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] targetArr = createTargetArr();
        char[][] gameBoard = createBoard();
        int attempts = 0;

        printBoard(gameBoard);
        System.out.println("All set. Get ready to rumble");
        while (attempts < 3) {
            System.out.println("Enter row");
            if (!isInputValid(sc)) {
                sc.nextLine();
                continue;
            }
            int row = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter column");
            if (!isInputValid(sc)) {
                sc.nextLine();
                continue;
            }
            int col = sc.nextInt();
            sc.nextLine();

            if (row > 5 || row <= 0 || col > 5 || col <= 0) {
                System.out.println("Invalid input.Enter again: ");
                continue;
            }
            row = row - 1;
            col = col - 1;
            if (isExist(row, col, targetArr, targetArr.length) && gameBoard[row][col] != 'x') {
                System.out.println("You have won!");
                gameBoard[row][col] = 'x';
                attempts++;
            } else if (gameBoard[row][col] == 'x') {
                System.out.println("You shot same place");
            } else {
                gameBoard[row][col] = '*';
            }

            if (attempts != 3) printBoard(gameBoard);
        }

        System.out.println("Congratulations!");
        printBoard(gameBoard);
    }

    public static int[][] createTargetArr() {
        int[][] targetArr = new int[3][2];
        int selection = random.nextInt(2);
        int row,col;

        targetArr[0][0] = random.nextInt(5);
        targetArr[0][1] = random.nextInt(5);

        for(int i=1;i<targetArr.length;i++){
            if(selection==0){
                row = targetArr[0][0] + random.nextInt(-1,2);
                col = targetArr[0][1];

                while(isExist(row,col,targetArr,i) || row>=5 || row<0 ){
                    row = targetArr[i-1][0] + random.nextInt(-1,2);
                }

            }else{
                row = targetArr[0][0];
                col = targetArr[0][1] + random.nextInt(-1,2);

                while(isExist(row,col,targetArr,i) || col>=5 || col<0 ){
                    col = targetArr[i-1][0] + random.nextInt(-1,2);
                }
            }


            targetArr[i][0] = row;
            targetArr[i][1] = col;
        }

        return targetArr;
    }

    public static boolean isExist(int row, int col, int[][] targetArr, int limit) {
        boolean isExist = false;
        for (int i = 0; i < limit; i++) {
            if (row == targetArr[i][0] && col == targetArr[i][1]) {
                isExist = true;
                break;
            }
        }

        return isExist;
    }

    public static boolean isInputValid(Scanner sc) {
        if (!sc.hasNextInt()) {
            System.out.println("Invalid input.Enter again: ");

            return false;
        }

        return true;
    }

    public static char[][] createBoard() {
        char[][] board = new char[5][5];
        for (char[] chars : board) {
            Arrays.fill(chars, '-');
        }

        return board;
    }

    public static void printBoard(char[][] board) {
        for (int i = 0; i <= board.length; i++) {
            System.out.print(i + "  ");
        }
        System.out.println();

        for (int i = 0; i < board.length; i++) {
            System.out.print(i + 1);
            System.out.print("  ");
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }

    }

}
