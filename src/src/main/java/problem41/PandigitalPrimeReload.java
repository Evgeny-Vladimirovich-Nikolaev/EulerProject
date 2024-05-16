package problem41;

import java.util.*;

public class PandigitalPrimeReload {

    private final int limit;
    private final boolean includeZero;
    private final List<Integer> primes = new ArrayList<>();
    private int max;

    public PandigitalPrimeReload(int limit, boolean includeZero) {
        this.limit = limit;
        this.includeZero = includeZero;

        long start = System.currentTimeMillis();
        max = findMax();
        long end = System.currentTimeMillis();

        System.out.println(end - start);

    }

    public int getMax() {
        return max;
    }
    public List<Integer> getPrimes() {
        return primes;
    }

    private int findMax() {
        findPrimes();
        if (includeZero) {
            return findMaxIncludeZero();
        } else {
            return findMaxExcludeZero();
        }
    }



    private void findPrimes() {
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

        } while (num < limit);
    }

    private int findMaxExcludeZero() {
        int ind = primes.size() - 1;
        while(ind >= 0) {
            if(isPandigitalExcludeZero(primes.get(ind))) {
                return primes.get(ind);
            }
            ind--;
        }
        throw new NoSuchElementException();
    }

    private int findMaxIncludeZero() {
        int ind = primes.size() - 1;
        while(ind >= 0) {
            if(isPandigitalIncludeZero(primes.get(ind))) {
                return primes.get(ind);
            }
            ind--;
        }
        throw new NoSuchElementException();
    }

    private boolean isPandigitalExcludeZero(int num) {
        final Set<Integer> set = new HashSet<>();
        int steps = 0;
        int max = 0;
        while (num > 0) {
            int res = num % 10;
            if(res == 0) {
                return false;
            }
            set.add(res);
            num /= 10;
            if(res > max) {
                max = res;
            }
            steps++;
        }
        if(set.size() == steps && max == steps) {
            return true;
        }
        return false;
    }

    private boolean isPandigitalIncludeZero(int num) {
        final Set<Integer> set = new HashSet<>();
        int steps = 0;
        int max = 0;
        while (num > 0) {
            int res = num % 10;
            if(res == 0 && !includeZero) {
                return false;
            }
            set.add(res);
            num /= 10;
            if(res > max) {
                max = res;
            }
            steps++;
        }
        if(set.size() == steps && max == steps - 1) {
            return true;
        }
        return false;
    }
}
