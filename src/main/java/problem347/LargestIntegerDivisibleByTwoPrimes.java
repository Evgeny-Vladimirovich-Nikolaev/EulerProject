package problem347;

import utils.primes.SieveOfEratosthenes;

import java.util.List;

/**
 * Наибольшее целое число ≤ 100, которое делится только на простые сомножители 2 и 3 равно 96, т.к. 96=32*3=2^5*3.
 * Для двух отличных простых чисел p и q определим M(p,q,N) как наибольшее натуральное число ≤N,
 * которое делится только на p и q, а если такого числа не существует, то M(p,q,N)=0.
 * Например, M(2,3,100)=96. M(3,5,100)=75, а не 90, т.к. 90 делится на 2 ,3 и 5.
 * Кроме того, M(2,73,100)=0, т.к. не существует такого натурального числа ≤ 100,
 * которое бы делилось как на 2, так и на 73. Пусть S(N) - сумма всех возможных M(p,q,N). S(100)=2262.
 * Найдите S(10 000 000).
 */

public class LargestIntegerDivisibleByTwoPrimes {

    private static final int LIMIT = 100;
    private static List<Integer> primes = new SieveOfEratosthenes(LIMIT / 2).getPrimesAsList();

    public static void main(String[] args) {
        System.out.println(sum());
    }

    private static int sum() {
        int sum = 0;
        for(int i = 0; i < primes.size(); i++) {
            final int fstDivisor = primes.get(i);
            int largestInt = fstDivisor;
            while(largestInt * fstDivisor < LIMIT) {
                largestInt *= fstDivisor;
            }
            for(int j = i + 1; j < primes.size(); j++) {
                final int sndDivisor = primes.get(j);
                largestInt *= sndDivisor;
                while(largestInt > LIMIT) {
                    largestInt /= fstDivisor;
                }
                while(largestInt % fstDivisor == 0 && largestInt % sndDivisor == 0) {

                }
            }
        }
        return sum;
    }

}