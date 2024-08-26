package problem035;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CircularPrimes {

    private static int size = 1_000_000;
    private static int[] arr = new int[size];
    private static List<Set<Integer>> circularPrimes = new ArrayList<>();

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 2; i < arr.length; i++) {
            if (isPrime(i)) {
                arr[i] = i;
            }
        }
        checkPrimes();
        Set<Integer> allNumbers = new TreeSet<>();
        for (Set set : circularPrimes) {
            for (Object ob : set) {
                allNumbers.add((Integer) ob);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("elapsed time: " + (end - start) + "ms");
        System.out.println(allNumbers);
        System.out.println(allNumbers.size());
    }

    private static boolean isPrime(int num) {
        final int limit = (int) Math.sqrt(num) + 1;
        for (int i = 2; i < limit; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static void checkPrimes() {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                Set set = new TreeSet();
                findCircularNumber(i, set);
                if (set.size() > 0) {
                    circularPrimes.add(set);
                }
            }
        }
    }

//    private static List<Integer> findRoundPrimes(int number) {
//        int numPos = 0;
//        int temp = number;
//        List<Integer> list = new ArrayList<>();
//        list.add(arr[number]);
//        while (temp > 0){
//            temp /= 10;
//            numPos++;
//        }
//        for(int i = 1; i <= numPos; i++) {
//            int remainder = number % 10;
//            number /= 10;
//            number += Math.pow(remainder, numPos);
//            if(arr[number] == number) {
//                list.add(number);
//                arr[number] = -1;
//            } else {
//                return null;
//            }
//        }
//        return list;
//    }


    private static void findCircularNumber(int num, Set set) {
        int numberPosition = countPositions(num);
        countRoundPrimes(num, numberPosition, numberPosition, set, true);
    }

    private static int countPositions(int num) {
        int numberPosition = -1;
        int temp = num;
        do {
            temp /= 10;
            numberPosition++;
        } while (temp != 0);
        return numberPosition;
    }

    private static void countRoundPrimes(int num, int numPos, int counter, Set<Integer> set, boolean isCircular) {
        set.add(num);
        if (counter == 0) {
            if (!isCircular) {
                set.clear();
            }
            return;
        }
        int remainder = num % 10;
        int temp = num;
        temp /= 10;
        temp += (remainder * Math.pow(10, numPos));
        if (arr[temp] != temp) {
            isCircular = false;
        }
        countRoundPrimes(temp, numPos, --counter, set, isCircular);
    }

}





















