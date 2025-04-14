package az.edu.turing.module3.lesson03;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{8,1,99,12,2,12,9,6,5,101,268,943,12,78,10,0,1,3,6,7,5,6,9,7,45,65,12,32,65,98,88,74};
        sort(arr,0,arr.length-1);

        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr,int start,int end){
        if(end<=start) return;

        int pivot  = sortByPivot(arr,start,end);

        sort(arr,pivot+1,end);
        sort(arr,start,pivot-1);
    }

    private static int sortByPivot(int[] arr,int start,int end){
        int i = start-1;
        int pivot = arr[end];

        for(int j=start;j<end;j++){
            if(arr[j]<pivot){
                i++;
                if(arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }

            }
        }

        i++;
        int temp = arr[i];
        arr[i] = arr[end];
        arr[end] = temp;

        return i;
    }

}