package problem136;

public class SingletonDifference {
    private static final int NUMBERS_SIZE = 50_000_000;
    private static final int SQUARES_SIZE = 100_000_000;

    private static final int[] numbers = new int[NUMBERS_SIZE];
    private static long[] squares;

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        fillSquares();
        fillNumbers();
        int count = countSingletonDifference();

        long end = System.currentTimeMillis();

        System.out.println(count);
        System.out.println(end - start);

    }

    private static void fillNumbers() {
        final int limit = squares.length - 2;
        int minStep = 1;
        for(int ind = 1; ind < limit; ind++) {
            for(int step = minStep; ind + step * 2 < squares.length; step++) {
                long res = squares[ind + step * 2] - squares[ind + step] - squares[ind];
                if(res < 0) {
                    minStep++;
                }
                else if(res >= numbers.length) {
                    break;
                }
                else {
                    numbers[(int)res]++;
                }
            }
        }
    }

    private static void fillSquares() {
        squares = new long[SQUARES_SIZE];
        squares[1] = 1;
        for (int i = 2; i < squares.length; i++) {
            squares[i] = (long) i * i;
        }
    }

    private static int countSingletonDifference() {
        int count = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == 1) {
                count++;
            }
        }
        return count;
    }

}