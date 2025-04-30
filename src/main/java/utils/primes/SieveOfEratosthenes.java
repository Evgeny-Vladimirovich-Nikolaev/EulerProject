package utils.primes;

import java.util.ArrayList;
import java.util.List;

public class SieveOfEratosthenes {

    private final int limit;
    private final boolean[] sieve;

    public SieveOfEratosthenes(int limit) {
        this.limit = limit;
        this.sieve = new boolean[limit];
        fillSieve();
    }

    private void fillSieve() {
        int max = (int) Math.sqrt(limit);
        int prime = 2;
        while (prime <= max) {
            int multiplier = 2;
            int number = prime * multiplier;
            while (number < limit) {
                sieve[number] = true;
                number = prime * ++multiplier;
            }
            do {
                prime++;
            } while (sieve[prime]);
        }
    }

    public List<Integer> getPrimesAsList() {
        List<Integer> primes;
        if (limit > 1000) {
            primes = new ArrayList<>(limit / 19);
        } else {
            primes = new ArrayList<>();
        }
        fillList(primes);
        return primes;
    }

    private void fillList(List<Integer> primes) {
        for (int ind = 2; ind < limit; ind++) {
            if (!sieve[ind]) {
                primes.add(ind);
            }
        }
    }

    public int[] getPrimesAsArray() {
        int size = 0;
        int[] primes;
        int ind = 0;
        for(int i = 2; i < sieve.length; i++) {
            if(!sieve[i]) {
                size++;
            }
        }
        primes = new int[size];
        for(int i = 2; i < sieve.length; i++) {
            if(!sieve[i]) {
                primes[ind++] = i;
            }
        }
        return primes;
    }

}