package az.edu.turing.module1.lesson04;

import java.util.Scanner;

public class MinMaxFinder {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of row: ");
        int row = sc.nextInt();

        int[][] arr = new int[row][];

        for (int i = 0; i < row; i++) {

            System.out.println("Enter column: ");
            int col = sc.nextInt();
            arr[i] = new int[col];

            for (int j = 0; j < col; j++) {
                arr[i][j] = sc.nextInt();
            }

        }

        int max = arr[0][0];
        int min = arr[0][0];

        for (int i = 0; i < arr.length; i++) {

            for (int j = 1; j < arr[i].length; j++) {

                if (arr[i][j] > max) {
                    max = arr[i][j];
                }

                if (arr[i][j] < min) {
                    min = arr[i][j];
                }

            }


        }

        System.out.println("min: " + min + ", max: " + max);

    }

}
