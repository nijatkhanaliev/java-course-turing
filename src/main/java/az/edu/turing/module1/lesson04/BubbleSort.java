package az.edu.turing.module1.lesson04;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        int[] arr = {7, 8, 9, 4, 35, 65, 2, 0, 8, 1};

        for (int i = 0; i < arr.length; i++) {

            int temp;
            for (int j = 0; j < arr.length - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }

            }

        }
        System.out.println(Arrays.toString(arr));

    }

}
