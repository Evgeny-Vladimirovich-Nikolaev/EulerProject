package main.java.problem136;

public class SingletonDifference {

//    final private static int SIZE = 50_000_000;
            final private static int SIZE = 100;
    final private static int[] numbers = new int[SIZE];

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        fillNumbers();
        int count = countSingletons();
        long end = System.currentTimeMillis();
        System.out.println(count);
        System.out.println(end - start);
    }

    private static void fillNumbers() {
        long start = System.currentTimeMillis();
        for (int i = 1; i < 10_000_000; i++) {
            for (int j = 1; j < 1_000_000; j++) {
                long res = (long) Math.pow(i + 2 * j, 2)
                        - (long) Math.pow(i + j, 2)
                        - (long) Math.pow(i, 2);
                if (res >= SIZE) {
                    if (i % 100_000 == 0) {
                        long now = System.currentTimeMillis();
                        System.out.println(i
                                + " : "
                                + j
                                + " "
                                + ((now - start) / 1000));
                    }
                    break;
                }
                if (res > 0) {
                    numbers[(int) res]++;
                }
            }
        }
    }

    private static int countSingletons() {
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1) {
                count++;
            }
        }
        return count;
    }

}
