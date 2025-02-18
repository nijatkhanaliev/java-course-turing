package az.edu.turing.module1.lesson04;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {

        int[] arr = {78, 89, 5, 2, 5, 0, 1, 2, 84, 23};

        for (int i = 0; i < arr.length; i++) {

            int temp;
            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }

            }

            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;

        }

        System.out.println(Arrays.toString(arr));

    }

}
