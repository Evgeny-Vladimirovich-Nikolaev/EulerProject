package main.java.problem060;

public class PrimePairSets2 {

    private static final int a = 3;
    private static final int b = 7;
    private static final int c = 109;
    private static final int d = 673;

    private static final int SPLIT_LIMIT = 2_000_000_000;

    private static final boolean[] compositeNumbers = new boolean[SPLIT_LIMIT];


    public static void main(String[] args) {
        fillCompositeNumbers();
        System.out.println(findMinPrimePairSetsSum());
    }

    private static void fillCompositeNumbers() {
        for (int i = 2; i < SPLIT_LIMIT; i++) {
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

    private static int findMinPrimePairSetsSum() {
        int num = d;
        do{
            num++;
        } while (
                !checkPair(num, a)
                        || !checkPair(num, b)
                        || !checkPair(num, c)
                        || !checkPair(num, d)
        );
        System.out.println(num);
            return a + b + c + d + num;
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
        int num = Integer.parseInt(composite.toString());
        return !compositeNumbers[num];
    }

}
