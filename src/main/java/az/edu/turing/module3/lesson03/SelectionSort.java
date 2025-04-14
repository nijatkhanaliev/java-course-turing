package az.edu.turing.module3.lesson03;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{47,21,0,23,4,6,98,78,53,2,1,4};
        sortSelection(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void sortSelection(int[] arr){
        for(int i=0;i<arr.length;i++){
            int min = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[min]){
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

}
