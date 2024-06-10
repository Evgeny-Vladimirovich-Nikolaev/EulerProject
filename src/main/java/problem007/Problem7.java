package main.java.problem007;

import java.util.ArrayList;
import java.util.List;

public class Problem7 {

    private static final List<Integer> primes = new ArrayList<>();
    private static final int COUNT = 10_001;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        findPrimes();
        long end = System.currentTimeMillis();
        System.out.println(primes.getLast());
        System.out.println(end - start);
        System.out.println(primes);
    }

    private static void findPrimes() {
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
        } while (primes.size() != COUNT);
    }
}
