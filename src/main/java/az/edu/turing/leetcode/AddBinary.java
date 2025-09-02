package az.edu.turing.leetcode;

import java.math.BigInteger;
import java.util.ArrayList;

public class AddBinary {
    public static void main(String[] args) {
        String aStr = "1010";
        String bStr = "1011";

        BigInteger a = new BigInteger(aStr, 10);
        BigInteger b = new BigInteger(bStr, 10);

        if(a.equals(BigInteger.ZERO) && b.equals(BigInteger.ZERO)){
            System.out.println(0);
        }

        BigInteger resultForA = BigInteger.ZERO;
        BigInteger resultForB = BigInteger.ZERO;

        int indexForA = 0;
        int indexForB = 0;

        while (a.compareTo(BigInteger.ZERO) > 0) {
            BigInteger digit = a.mod(BigInteger.TEN);
            resultForA = resultForA.add(BigInteger.valueOf(2).pow(indexForA++).multiply(digit));
            a = a.divide(BigInteger.TEN);
        }

        while (b.compareTo(BigInteger.ZERO) > 0) {
            BigInteger digit = b.mod(BigInteger.TEN);
            resultForB = resultForB.add(BigInteger.valueOf(2).pow(indexForB++).multiply(digit));
            b = b.divide(BigInteger.TEN);
        }
        System.out.println(resultForB);
        System.out.println(resultForA);


        BigInteger result = resultForA.add(resultForB);
        ArrayList<BigInteger> list = new ArrayList<>();

        System.out.println(result);

        while (result.compareTo(BigInteger.ZERO) >= 1) {
            BigInteger digit = result.mod(BigInteger.TWO);
            System.out.println(digit);
            list.add(digit);
            result = result.divide(BigInteger.TWO);
        }
        System.out.println(list);

        StringBuilder total = new StringBuilder();

        for (int i = list.size() - 1; i >= 0; i--) {
            total.append(list.get(i));
        }
        System.out.println(total);
    }
}
