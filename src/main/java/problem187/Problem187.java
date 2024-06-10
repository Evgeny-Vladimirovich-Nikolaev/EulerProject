package main.java.problem187;

import java.util.ArrayList;
import java.util.List;

public class Problem187 {

    private static final List<Integer> primes = new ArrayList<>();
    private static final int LIMIT = 100_000_000;
    private static int semiPrimes;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        countSemiPrimes();
        long end = System.currentTimeMillis();
        System.out.println(semiPrimes);
        System.out.println(end - start);
    }

    private static void countSemiPrimes() {
        int number = 2;
        primes.add(number);
        do {
            number++;
            boolean isPrime = true;
            int maxDivisor = (int) Math.sqrt(number) + 1;
            for (Integer prime : primes) {
                if (prime > maxDivisor) {
                    break;
                }
                if (number % prime == 0) {
                    if (isPrime(number / prime)) {
                        semiPrimes++;
                    }
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(number);
            }
        } while (number < LIMIT);
    }

    private static boolean isPrime(int number) {
        if(number == 2) {
            return true;
        }
        int maxDivisor = (int) Math.sqrt(number) + 1;
        for (int i = 2; i <= maxDivisor; i++) {
            if (number % i == 0) {
                return false;
            }
            if (i > maxDivisor) {
                break;
            }
        }
        return true;
    }
}
