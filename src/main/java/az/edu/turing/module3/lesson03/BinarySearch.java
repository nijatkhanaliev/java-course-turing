package az.edu.turing.module3.lesson03;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(searchBinary(new int[]{ 5,8,10}, 10));
    }

    public static int searchBinary(int[] arr, int target){
        Arrays.sort(arr);//5, 8, 10
        int left=0, right=arr.length-1;
        while(left<=right){ //
            int med = (left+right)/2;
            if(arr[med]>target){
                right = med-1;
            }else if(arr[med]<target){
                left=med+1;
            }if(arr[med]==target){
                return med;
            }
        }

        return -1;
    }
}
