package az.edu.turing.leetcode;

public class Sqrtx {

    public static void main(String[] args) {
        System.out.println(mySqrt(8));
        System.out.println(mySqrt(21512343));
        System.out.println(mySqrt(87));
        System.out.println(mySqrt(32));

    }

    public static int mySqrt(int x) {
        int left = 1;
        int right = x;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long produce = (long) mid * mid;

            if (produce == x) {
                return mid;
            } else if (produce > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return right;

    }

}
