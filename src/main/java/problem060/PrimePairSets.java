package problem060;

import java.util.Arrays;

public class PrimePairSets {

    private static final int LIMIT = 100_000_000;
    private static final boolean[] compositeNumbers = new boolean[LIMIT];
    private static int max = LIMIT;

    public static void main(String[] args) {
        fillCompositeNumbers();
        findMinPrimePairSetsSum();
        System.out.println(max);
    }


    private static void fillCompositeNumbers() {
        for(int i = 2; i < LIMIT; i++) {
            if(!compositeNumbers[i]) {
                int j = i;
                int product = j * i;
                while(product < LIMIT && product > 0) {
                    compositeNumbers[product] = true;
                    product = ++j * i;
                }
            }
        }
    }

    private static void findMinPrimePairSetsSum() {
        for(int i = 3; i < max; i++) {
            if(compositeNumbers[i]) continue;
            for(int j = i + 2; i + j < max; j++) {
                if(compositeNumbers[j]
                || !checkPair(i, j)) {
                    continue;
                }
                for(int k = j + 2; i + j + k < max; k++) {
                    if(compositeNumbers[j]
                            || !checkPair(i, k)
                            || !checkPair(j, k)) {
                        continue;
                    }
                    for(int m = k + 2; i + j + k + m < max; m++) {
                        if(compositeNumbers[j]
                                || !checkPair(i, m)
                                || !checkPair(j, m)
                                || !checkPair(k, m)) {
                            continue;
                        }
                        for(int n = m + 2; i + j + k + m + n < max; n++) {
                            if(compositeNumbers[j]
                                    || !checkPair(i, m)
                                    || !checkPair(j, m)
                                    || !checkPair(k, m)) {
                                continue;
                            }
                            max = i + j + k + m + n;
                        }
                    }
                }
            }
        }
    }

    private static boolean checkPair(int fst, int snd){
        return false;
    }


}
