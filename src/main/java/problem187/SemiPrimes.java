package main.java.problem187;

import java.util.ArrayList;
import java.util.List;

public class SemiPrimes {

    private static final int LIMIT = 10_000_000;
    private static List<Integer> primes = new ArrayList<>();

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        fillPrimes();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    private static void fillPrimes() {
        int num = 2;
        primes.add(num);
        do{
            boolean isPrime = true;
            final int maxDiv = (int) Math.sqrt(++num) + 1;
            for (Integer integer : primes) {
                if(integer > maxDiv) {
                    break;
                }
                if (num % integer == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                primes.add(num);
            }
        } while (primes.size() != LIMIT);
    }

}
