package az.edu.turing.module1.lesson05;

import java.util.Arrays;
import java.util.Scanner;

public class NumberGuesser {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name: ");
        String name = sc.nextLine();
        System.out.println("Let the game begin!");

        int hiddenNumber = (int) (Math.random() * 101);
        int[] enteredNumbersArr = new int[1];
        int count = 0;
        boolean isGameTerminated = false;

        while (true) {
            int enteredNumber = enterNumber("Enter the number: ", sc);
            enteredNumbersArr[count] = enteredNumber;
            count++;

            isGameTerminated = printMessage(enteredNumber, hiddenNumber, name, isGameTerminated);

            if (isGameTerminated) {
                sc.close();
                break;
            }

            enteredNumbersArr = createNewNumbersArr(count, enteredNumbersArr);

        }

        sortLargerToSmaller(enteredNumbersArr);
        System.out.println("Your numbers: " + Arrays.toString(enteredNumbersArr));
    }


    public static int enterNumber(String message, Scanner sc) {
        try {
            System.out.println(message);
            return sc.nextInt();
        } catch (Exception e) {
            sc.nextLine();
            return enterNumber("Enter number again: ", sc);
        }
    }

    public static void sortLargerToSmaller(int[] enteredNumbersArr) {
        for (int i = 0; i < enteredNumbersArr.length; i++) {
            for (int j = 0; j < enteredNumbersArr.length - i - 1; j++) {
                if (enteredNumbersArr[j] < enteredNumbersArr[j + 1]) {
                    int temp = enteredNumbersArr[j];
                    enteredNumbersArr[j] = enteredNumbersArr[j + 1];
                    enteredNumbersArr[j + 1] = temp;
                }
            }
        }
    }

    public static boolean printMessage(int enteredNumber, int hiddenNumber, String name, boolean isGameTerminated) {
        if (enteredNumber > hiddenNumber) {
            System.out.println("Your number is too big. Please, try again.");
        } else if (enteredNumber < hiddenNumber) {
            System.out.println("Your number is too small. Please, try again.");
        } else {
            System.out.println("Congratulations," + name + "!");
            isGameTerminated = true;
        }
        return isGameTerminated;
    }

    public static int[] createNewNumbersArr(int count, int[] enteredNumbersArr) {
        int[] newEnteredNumbersArr = new int[count + 1];
        for (int i = 0; i < count; i++) {
            newEnteredNumbersArr[i] = enteredNumbersArr[i];
        }

        return newEnteredNumbersArr;
    }

}
