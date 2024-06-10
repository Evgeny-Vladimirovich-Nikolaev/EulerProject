package main.java.problem041;

import java.util.HashSet;
import java.util.Set;

public final class PandigitalPrime {

    private final int limit;
    private final boolean includeZero;
    private int max;

    public PandigitalPrime(int limit, boolean includeZero) {
        this.limit = limit;
        this.includeZero = includeZero;
        max = findMax();
    }

    public int getMax() {
        return max;
    }
    
    private int findMax() {
        long start = System.currentTimeMillis();
        for(int num = limit; num > 0; num--) {
            if(isPrime(num) && isPandigital(num)) {
                long end = System.currentTimeMillis();
                System.out.println(end - start);

                return num;
            }
            if(num %1_000_000 == 0) {
                System.out.println(num);
            }
        }
        return 2;
    }

    private boolean isPrime(int num) {
        final int divLim = (int) Math.sqrt(num) + 1;
        for(int div = 2; div < divLim; div++) {
            if(num % div == 0) {
                return false;
            }
        }
        return true;
    }

    private boolean isPandigital(int num) {
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
        if(set.size() == steps && max == steps) {
            return true;
        }
        return false;
    }
    
}
