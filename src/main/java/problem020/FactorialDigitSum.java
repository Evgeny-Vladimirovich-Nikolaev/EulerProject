package main.java.problem020;

import java.math.BigInteger;

public class FactorialDigitSum {

    private static final int NUMBER = 100;

    public static void main(String[] args) {
        BigInteger factorial = calculateFactorial();
        int sum = calculateDigitsSum(factorial);
        System.out.println(sum);
    }

    private static BigInteger calculateFactorial() {
        BigInteger res = BigInteger.valueOf(1);
        for(int i = 2; i <= NUMBER; i++) {
            res = res.multiply(BigInteger.valueOf(i));
            System.out.println(res);
        }
        return res;
    }

    private static int calculateDigitsSum(BigInteger factorial) {
        int result = 0;
        String s = factorial.toString();
        for(int i = 0; i < s.length(); i++) {
           result += s.charAt(i) - 48;
        }
        return result;
    }

}
