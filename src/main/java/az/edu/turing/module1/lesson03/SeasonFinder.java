package az.edu.turing.module1.lesson03;

import java.util.Scanner;

public class SeasonFinder {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number:");
        int input = scanner.nextInt();
        String output;

        if (input == 12 || input == 1 || input == 2) {
            output = "Winter";
        } else if (input == 3 || input == 4 || input == 5) {
            output = "spring";
        } else if (input == 6 || input == 7 || input == 8) {
            output = "summer";
        } else if (input == 9 || input == 10 || input == 11) {
            output = "autumn";
        } else {
            output = "Invalid";
        }

        System.out.println(output);
    }

}
