package problem;

import utils.primes.SieveOfEratosthenes;

public class EightDivisors {

    private static final long N = 8_000_000_000L;
    private static int[] primes;
    private static int numbersCounter = 0;

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        System.out.println((int) N / 6);

        primes = new SieveOfEratosthenes((int) (N / 6)).getPrimesAsArray();
        System.out.println("primes.length: " + primes.length);
        System.out.println(primes[0]);
        System.out.println(primes[primes.length - 1]);
        calculateNumbers();

        long end = System.currentTimeMillis();
        System.out.println(numbersCounter);
        System.out.println("time: " + (end - start));
    }

    private static void calculateNumbers() {
        calculateWithOneMultiplier();
        calculateWithTwoMultipliers();
        calculateWithThreeMultipliers();
    }

    private static void calculateWithOneMultiplier() {
        for (Integer multiplier : primes) {
            if (Math.pow(multiplier, 7) <= N) {
                numbersCounter++;
            } else {
                break;
            }
        }
    }

    private static void calculateWithTwoMultipliers() {
        for (int i = 0; i < primes.length; i++) {
            long intermediateRes = (long) Math.pow(primes[i], 3);
            if (intermediateRes <= N) {
                for (int j = 0; j < primes.length; j++) {
                    if (i == j) {
                        continue;
                    }
                    if (intermediateRes * primes[j] <= N) {
                        numbersCounter++;
                    } else {
                        break;
                    }
                }
            } else {
                break;
            }
        }
    }

    private static void calculateWithThreeMultipliers() {
        for (int i = 0; i < primes.length - 2; i++) {
            for (int j = i + 1; j < primes.length - 1; j++) {
                long intermediateRes = (long) primes[i] * primes[j];
                if (intermediateRes < N) {
                    for (int k = j + 1; k < primes.length; k++) {
                        if (intermediateRes * primes[k] <= N) {
                            numbersCounter++;
                        } else {
                            break;
                        }
                    }
                } else {
                    break;
                }
            }
        }
    }


}
