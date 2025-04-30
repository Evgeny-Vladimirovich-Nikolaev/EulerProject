package problem050;

import utils.primes.SieveOfEratosthenes;

import java.util.List;

public class ConsecutivePrimeSum {

    private static final int LIMIT = 1_000_000;
    private static SieveOfEratosthenes sieveOfEratosthenes = new SieveOfEratosthenes(LIMIT);
    private static List<Integer> primes = sieveOfEratosthenes.getPrimesAsList();

    private static int length = 0;
    private static int sum = 0;
    private static int start = 0;
    private static int end = 0;

    public static void main(String[] args) {
        findNumber();
        System.out.println(length);
        System.out.println(sum);
    }

    private static void findNumber() {

        for(int i = 0; i < primes.size(); i++) {
            int temp = 0;
            int len = 0;
            for(int j = i; j < primes.size(); j++) {
                temp += primes.get(j);
                if(temp >=  LIMIT) {
                    break;
                }
                len++;
                if(primes.contains(temp) && len > length) {
                    length = len;
                }
            }
        }

    }

    private static void incorrectSolution() {
        int end = start;
        while(primes.size() - start > length) {
            int len = length;
            while (end < primes.size()) {
                sum += primes.get(end++);
                len++;
                if(sum > LIMIT) {
                    break;
                }
                if(primes.contains(sum) && len > length) {
                    length = len;
                }
            }
            sum -= primes.get(start++);
            int ind = start + length;
            for(; ind < primes.size(); ind++) {
                sum -= primes.get(ind);
            }
        }
    }

    private static void firstPass() {
        int len = length;
        int ind = start + length;
       while (sum < LIMIT && ind < primes.size()) {
            sum += primes.get(ind);
            len++;
            if(primes.contains(sum) && len > length) {
                length = len;
                end = ind;
            }
            ind++;
        }
    }

    private static void secondPass() {
        int temp = sum;
        temp -= primes.get(start);
    }

    private static void first() {

    }

    private static void second() {

    }

}
