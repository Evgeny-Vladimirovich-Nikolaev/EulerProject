package problem10;

public class SummationOfPrimes {

    private final static int LIMIT = 2_000_000;
//    private final static int LIMIT = 10;
    private final static boolean[] COMPOSITE_NUMBERS = new boolean[LIMIT];
    private static long result = 0;

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        fillCompositeNumbers();
        calculateResult();

        long end = System.currentTimeMillis();

        System.out.println(result);
        System.out.println(end - start);

    }

    private static void fillCompositeNumbers() {
        int i = 2;
        while(i * i < LIMIT) {
            if (!COMPOSITE_NUMBERS[i]) {
                int j = i;
                int num = i * j;
                while(num < LIMIT) {
                    COMPOSITE_NUMBERS[num] = true;
                    num = i * ++j;
                }
            }
            i++;
        }
    }

    private static void calculateResult() {
        for(int ind = 2; ind < LIMIT; ind++) {
            if(!COMPOSITE_NUMBERS[ind]) {
                result += ind;
            }
        }
    }

}
