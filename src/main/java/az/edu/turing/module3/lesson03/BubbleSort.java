package az.edu.turing.module3.lesson03;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
       int[] arr = new int[]{47,21,0,23,4,6,98,78,53,2,1,4};
        sortBubble(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void sortBubble(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
               if(arr[j]>arr[j+1]){
                   int temp = arr[j];
                   arr[j]=arr[j+1];
                   arr[j+1]=temp;
               }
            }
        }
    }

}
