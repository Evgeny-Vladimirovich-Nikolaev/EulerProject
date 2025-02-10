package utils.primes;

import java.util.ArrayList;
import java.util.List;

public class SieveOfEratosthenes {

    private final int limit;
    private final boolean[] sieve;
    private final List<Integer> primes;

    public SieveOfEratosthenes(int limit) {
        this.limit = limit;
        this.sieve = new boolean[limit];
        this.primes = new ArrayList<>();
        fillSieve();
        fillPrimes();
    }

    public List<Integer> getPrimes() {
        return primes;
    }

    private void fillSieve() {
        int max = (int) Math.sqrt(limit);
        int prime = 2;
        while (prime < max) {
            int multiplier = 2;
            int number = prime * multiplier;
            while(number < limit) {
                sieve[number] = true;
                number = prime * ++multiplier;
            }
            do {
                prime++;
            } while (sieve[prime]);
        }
    }

    private void fillPrimes() {
        for(int ind = 2; ind < limit; ind++) {
            if(!sieve[ind]) {
                primes.add(ind);
            }
        }
    }
}
