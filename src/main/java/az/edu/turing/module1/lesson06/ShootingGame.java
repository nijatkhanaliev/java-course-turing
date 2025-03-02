package az.edu.turing.module1.lesson06;


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
            System.out.println("Enter a row and column: ");
            if (!isInputValid(sc)) {
                sc.nextLine();
                continue;
            }
            int row = sc.nextInt();

            if (!isInputValid(sc)) {
                sc.nextLine();
                continue;
            }
            int col = sc.nextInt();

            sc.nextLine();

            if (row >= 5 || row < 0 || col >= 5 || col < 0) {
                System.out.println("Invalid input.Enter again: ");
                continue;
            }

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
        int row;
        int col;

        for (int i = 0; i < targetArr.length; i++) {
            row = random.nextInt(5);
            col = random.nextInt(5);
            while (isExist(row, col, targetArr, i)) {
                row = random.nextInt(5);
                col = random.nextInt(5);
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
            for (int i = 0; i < chars.length; i++) {
                chars[i] = '-';
            }
        }

        return board;
    }

    public static void printBoard(char[][] board) {
        for (char[] chars : board) {
            for (char ch : chars) {
                System.out.print(ch);
            }
            System.out.println();
        }
    }

}
