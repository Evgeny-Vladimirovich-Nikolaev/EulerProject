package extra01;

import problem41.PandigitalPrimeReload;

import java.util.ArrayList;
import java.util.List;

public class ExtraPrimes {

    private final static long LIMIT = Long.MAX_VALUE;
    private List<Long> primes;
    private Long maxDivisor;

    ExtraPrimes() {
        primes = new ArrayList<>();
        findPrimes();
        System.out.println("size: " + primes.size() + " " +primes.getLast());
    }

    private void findPrimes() {
        long num = 2;
        primes.add(num);
        do{
            boolean isPrime = true;
            final long maxDiv = (int) Math.sqrt(++num) + 1;
            for (Long l : primes) {
                if(l > maxDiv) {
                    break;
                }
                if (num % l == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                primes.add(num);
                if (primes.size() % 1_000_000 == 0) {
                    writeMessage(primes.size(), num);
                }
            }

        } while (num <= Long.MAX_VALUE);
    }

    private boolean isPrime(long num) {
        final int divLim = (int) Math.sqrt(num) + 1;
        for(int div = 2; div < divLim; div++) {
            if(num % div == 0) {
                return false;
            }
        }
        return true;
    }

    private void writeMessage(int ind, long num) {
        StringBuilder sb = new StringBuilder(Long.toString(num));
        sb = sb.reverse();
        for(int i = 3; i < sb.length(); i += 4) {
            sb.insert(i, "_");
        }
        sb = sb.reverse();
        System.out.println(ind / 1_000_000 + " m.: " + sb);
    }
}
