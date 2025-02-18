package az.edu.turing.module1.lesson04;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] arr = {2, 7, 12, 9, 7, 4, 3, 6};
        quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));

    }

    private static void quickSort(int[] arr, int start, int end) {

        if (end <= start) return;

        int pivot = sortByPivot(arr, start, end);
        quickSort(arr, start, pivot - 1);
        quickSort(arr, pivot + 1, end);

    }

    private static int sortByPivot(int[] arr, int start, int end) {
        int i = start - 1;
        int pivot = arr[end];

        for (int j = start; j < end; j++) {

            if (arr[j] < pivot) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }

        }

        i++;
        int temp = arr[i];
        arr[i] = arr[end];
        arr[end] = temp;

        return i;
    }

}
