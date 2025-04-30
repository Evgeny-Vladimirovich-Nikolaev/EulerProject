package problem204;

import utils.primes.SieveOfEratosthenes;

import java.util.*;

public class GeneralisedHammingNumbers {

    private static final int HAMMING_TYPE = 5;
    private static final int MAX = 100_000_000;
    private static List<Integer> primes = new SieveOfEratosthenes(MAX + 1).getPrimesAsList();
    private static List<List<Integer>> primeNumbersPowers = new ArrayList<>(primes.size());
    private static List<List<Integer>>  primeNumbersProducts = new ArrayList<>();
    private static Set<Integer> nonHammingNumbers = new HashSet<>();
    private static int hammingNumbersCounter = MAX;

    public static void main(String[] args) {
        findHammingNumbers(1, 0);
        System.out.println(primes.size());
//        System.out.println(primes);
//        System.out.println(primeNumbersPowers);
//        System.out.println(primeNumbersPowers.size());
//        System.out.println(primeNumbersProducts.size());
//        System.out.println(hammingNumbers.size());
        System.out.println(hammingNumbersCounter);
    }

    private static void findHammingNumbers(int n, int ind) {
//        firstPass();
//        secondPass();
//        thirdPass();
        bruteForce();
    }

    private static void bruteForce() {
        for (Integer prime : primes) {
            if (prime > HAMMING_TYPE) {
                int multiplier = 1;
                int num = prime;
                do{
                    nonHammingNumbers.add(num);
                    num = prime * ++multiplier;
                } while (num <= MAX);
            }
        }
        hammingNumbersCounter -= nonHammingNumbers.size();
    }

    private static void firstPass() {
        nonHammingNumbers.add(1);
        for(Integer integer : primes) {
            List<Integer> integerPowers = new ArrayList<>();
            primeNumbersPowers.add(integerPowers);
            int power = integer;
            while(power <= MAX) {
                integerPowers.add(power);
                nonHammingNumbers.add(power);
                power *= integer;
            }
        }
    }

    private static void secondPass() {
        for(int i = 0; i < primeNumbersPowers.size() - 1; i++) {
            for(int j = i + 1; j < primeNumbersPowers.size(); j++) {
                for(Integer outer : primeNumbersPowers.get(i)) {
                    List<Integer> products = new ArrayList<>();
                    for(Integer inner : primeNumbersPowers.get(j)) {
                        int product = outer * inner;
                        if(product <= MAX) {
                            products.add(product);
                            nonHammingNumbers.add(product);
                        } else {
                            break;
                        }
                    }
                    if(!products.isEmpty()) {
                        primeNumbersProducts.add(products);
                    }
                }
            }
        }
    }

    private static void thirdPass() {
        for (int i = 0; i < primeNumbersPowers.size(); i++) {
            for(int j = 0; j < primeNumbersPowers.get(i).size(); j++) {
                List<Integer> products = new ArrayList<>();
                for(int k = 0; k < primeNumbersProducts.size(); k++) {
                    for(int m = 0; m < primeNumbersProducts.get(k).size(); m++) {
                        int product = primeNumbersPowers.get(i).get(j) * primeNumbersProducts.get(k).get(m);
                        if(product <= MAX) {
                            products.add(product);
                            nonHammingNumbers.add(product);
                        } else {
                            break;
                        }
                    }
                }
                if(!products.isEmpty()) {
                    primeNumbersProducts.add(products);
                }
            }
        }
    }

}
