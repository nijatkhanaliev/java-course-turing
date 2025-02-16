package az.edu.turing.module1.lesson03;

import java.util.Scanner;

public class MonthFinder {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number:");
        int input = scanner.nextInt();
        String output;

        switch (input) {
            case 1 -> output = "January";
            case 2 -> output = "February";
            case 3 -> output = "March";
            case 4 -> output = "April";
            case 5 -> output = "May";
            case 6 -> output = "June";
            case 7 -> output = "July";
            case 8 -> output = "August";
            case 9 -> output = "September";
            case 10 -> output = "October";
            case 11 -> output = "November";
            case 12 -> output = "December";
            default -> output = "Invalid";
        }

        System.out.println(output);
    }

}
