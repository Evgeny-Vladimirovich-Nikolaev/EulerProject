package main.java.problem060;

import java.util.ArrayList;
import java.util.List;

public class PrimePairSets {

    private static final int SPLIT_LIMIT = 2_100_000_000;
    private static final int SUM_LIMIT = 34_444;
    private static final boolean[] compositeNumbers = new boolean[SPLIT_LIMIT];
    private static final List<Long> primeNumbers = new ArrayList<>(104134393);
    private static int min = SUM_LIMIT;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        fillCompositeNumbers();
        fillPrimeNumbers();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(primeNumbers.size());
        System.out.println(primeNumbers.get(primeNumbers.size() - 1));
        findMinPrimePairSetsSum();
        int amount = 0;
        int max = 2;
        for(int i = 2; i < compositeNumbers.length; i++) {
            if(!compositeNumbers[i]) {
                amount++;
                max = i;
            }
        }
        System.out.println(amount);
        System.out.println(max);
        for(int i = compositeNumbers.length - 1; i > 2099999959; i--) {
            if(!compositeNumbers[i]) {
                System.out.println(i);
            }
        }
    }

    private static void fillPrimeNumbers() {
        for(int i = 0; i < compositeNumbers.length; i++) {
            if(!compositeNumbers[i]) {
                primeNumbers.add((long) i);
            }
        }
   }


    private static void fillCompositeNumbers() {
        for (int i = 2; i < min; i++) {
            if (!compositeNumbers[i]) {
                int j = i;
                int product = j * i;
                while (product < SPLIT_LIMIT && product > 0) {
                    compositeNumbers[product] = true;
                    product = ++j * i;
                }
            }
        }
    }

    private static void findMinPrimePairSetsSum() {
        for (int i = 3; i < min; i += 2) {
            if (compositeNumbers[i]) continue;
            for (int j = i + 2; i + j < min; j += 2) {
                if (compositeNumbers[j]
                        || !checkPair(i, j)) {
                    continue;
                }
                for (int k = j + 2; i + j + k < min; k += 2) {
                    if (compositeNumbers[k]
                            || !checkPair(i, k)
                            || !checkPair(j, k)) {
                        continue;
                    }
                    for (int m = k + 2; i + j + k + m < min; m += 2) {
                        if (compositeNumbers[m]
                                || !checkPair(i, m)
                                || !checkPair(j, m)
                                || !checkPair(k, m)) {
                            continue;
                        }

                        for (int n = m + 2; i + j + k + m + n < min; n += 2) {
//                            System.out.println((m + " " + n));
                            if (!compositeNumbers[n]
                                    || !checkPair(i, n)
                                    || !checkPair(j, n)
                                    || !checkPair(k, n)
                                    || !checkPair(m, n)) {
                                continue;
                            }
                            min = i + j + k + m + n;
                            System.out.println(i + " + " + j + " + " + k + " + " + m + " + " + n + " = " + min);
                            break;
                        }
//                        break;
                    }
//                    break;
                }
//                break;
            }
        }
    }

    private static boolean checkPair(int fst, int snd) {
        StringBuilder composite = new StringBuilder(Integer.toString(fst));
        composite.append(snd);
        if (!isPrime(composite)) return false;
        composite = new StringBuilder(Integer.toString(snd));
        composite.append(fst);
        return isPrime(composite);
    }

    private static boolean isPrime(StringBuilder composite) {
        long num = Long.parseLong(composite.toString());
        return !compositeNumbers[(int) num];
    }

}
