package problem35;

import java.util.*;

public class Primes {

    private static int limit;
    private static int[] arr;
    private static List<Integer>primes;

    private static Set<Integer> circularPrimes;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        {
            limit = 1_000_000;
            arr = new int[limit];
            primes = new ArrayList<>();
            circularPrimes = new TreeSet<>();
        }

        findPrimes();
        fillArray();
        checkPrimes();

        long end = System.currentTimeMillis();

        System.out.println("Total calculation time: " + (end - start));
        System.out.println(circularPrimes);
        System.out.println("Amount of circular primes: " + circularPrimes.size());
    }

    private static void findPrimes() {
        for (int num = 2; num < limit; num++) {
            boolean isPrime = true;
            final int maxDiv = (int) Math.sqrt(num) + 1;
            for (Integer integer : primes) {
                if(integer > maxDiv) {
                    break;
                }
                if (num % integer == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime)primes.add(num);
        }
    }

    private static void fillArray() {
        for (Integer integer : primes) {
            arr[integer] = integer;
        }
    }

    private static void checkPrimes() {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                Set<Integer> set = new HashSet();
                findCircularNumber(i, set);
               for (Integer integer : set) {
                   circularPrimes.add(integer);
               }
            }
        }
    }

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
