package problem050;

import utils.primes.SieveOfEratosthenes;

import java.util.List;

public class NewPrime {

    private static final int LIMIT = 1_000_000;
    private static List<Integer> primes;
    private static int start = 0;
    private static int length = 0;
    private static int sum = 0;

    public static void main(String[] args) {
        SieveOfEratosthenes sieveOfEratosthenes = new SieveOfEratosthenes(LIMIT);
        primes = sieveOfEratosthenes.getPrimes();
        System.out.println(primes.size());
        someAttempt();
        System.out.println(length + " " + sum);
    }

    private static void someAttempt() {
        for (int i = 0; i < primes.size() - 1; i++) {
            int temp = 0;
            int len = 0;
            for (int j = i; j < primes.size(); j++) {
                temp += primes.get(j);
                if (temp >= LIMIT) {
                    break;
                }
                len++;
                if (primes.contains(temp) && len > length) {
                    length = len;
                    sum = temp;
                }
            }
        }
    }

    private static void findSum() {
        singlePass(0);
        System.out.println(sum);
        System.out.println(length);
        while (length < primes.size() - length) {
            sum -= primes.get(start++);
            int len = singlePass(length - 1);
            if (len >= length) {
                length = len;
                System.out.println(sum);
                System.out.println(length);
            }

        }
    }

    private static int singlePass(int len) {
        int ind = start + len;
        int temp = sum;
        while (ind < primes.size()) {
            temp += primes.get(ind++);
            len++;
            if (temp < LIMIT && primes.contains(temp)) {
                sum = temp;
            }
        }
        return len;
    }
}
