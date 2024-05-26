package problem136;

public class SingletonDifferenceThirdAttempt {

    private static final int[] numbers = new int[50_000_000];
    private static long[] squares;

    public static void main(String[] args) {
        fillSquares();
//        experience();
    }

    private static void fillSquares() {
        squares = new long[99_999_997];
        long start = System.currentTimeMillis();
        for(int i = 2; i < squares.length; i++) {
            squares[i] = i * i;
        }
        System.out.println(System.currentTimeMillis() - start);;
    }



}
