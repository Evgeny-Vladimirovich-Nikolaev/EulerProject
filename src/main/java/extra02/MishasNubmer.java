package main.java.extra02;

import java.util.ArrayList;
import java.util.List;

public class MishasNubmer {

    private static final int RESULT = 739;
    private static List<Integer> suitableNumbers = new ArrayList<>();

    public static void main(String[] args) {
        findMishasNumber();
        System.out.println(suitableNumbers);
        System.out.println(suitableNumbers.size());
    }

    private static List<Integer> findMishasNumber() {
        List<Integer> results = new ArrayList<>();
            for(int i = 1000; i < 10_000; i++) {
                int extractDigitSum = i - digitSum(i);
                if(checkDifference(extractDigitSum)) {
                    System.out.println(i + " - " + digitSum(i) + " = " + extractDigitSum);
                    suitableNumbers.add(i);
                }
            }
        return results;
    }

    private static int digitSum(int i) {
//        int  check = List.of(Integer.toString(i).toCharArray()).stream().mapToInt(k -> Integer.valueOf("" + k)).sum();
//        System.out.println(i + " =>  " + check);
//        return List.of(Integer.toString(i).toCharArray()).stream().mapToInt(k -> Integer.valueOf("" + k)).sum();
        int res = 0;
        char[] chars = Integer.toString(i).toCharArray();
        for(int j = 0; j < chars.length; j++) {
            res += (chars[j] - 48);
        }
        return res;


        }

        private static boolean checkDifference(int difference) {
            if(difference % 1000 == RESULT || difference / 10 == RESULT) {
                return true;
            }
            return false;
        }

}
