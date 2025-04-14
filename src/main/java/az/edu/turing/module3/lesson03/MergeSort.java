package az.edu.turing.module3.lesson03;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{8, 1, 99, 12, 2, 12, 9, 6, 5, 101, 268, 943, 12, 78, 10, 0, 1, 3, 6, 7, 5, 6, 9, 7, 45, 65, 12, 32, 65, 98, 88, 74};
        sort(arr,  arr.length);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int length) {
        if (length<2) {
            return;
        }

        int mid = length / 2;
        int[] l = new int[mid];
        int[] r = new int[length - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = arr[i];
        }

        for (int i = mid; i < length; i++) {
            r[i - mid] = arr[i];
        }

        sort(l, l.length);
        sort(r, r.length);

        merge(arr, l, r, mid, length - mid);

    }

    private static void merge(int[] arr, int[] l, int[] r, int leftLength, int rightLength) {
        int i = 0, j = 0, k = 0;

        while (i < leftLength && j < rightLength) {
            if (l[i] < r[j]) {
                arr[k++] = l[i++];
            } else {
                arr[k++] = r[j++];
            }
        }

    }

}