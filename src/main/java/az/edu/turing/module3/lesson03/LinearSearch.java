package az.edu.turing.module3.lesson03;

public class LinearSearch {

    public static void main(String[] args) {
        System.out.println(searchLinear(new int[]{87, 1, 2, 4, 3, 6, 5, 7, 21, 5}, 100));

    }

    public static int searchLinear(int[] arr, int target){
        for(int i=0; i<arr.length; i++){
            if(arr[i]==target){
                return i;
            }
        }
        return -1;
    }

}
