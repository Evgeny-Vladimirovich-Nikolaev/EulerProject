package problem119;

public class DigitPowerSum {
    private static final long A10 = 614656;
    private static final int[][] REMAINDERS =
            new int[][]{
                    {},
                    {1},
                    {2, 4, 8, 6},
                    {3, 9, 7, 1},
                    {4, 6},
                    {5},
                    {6},
                    {7, 9, 3, 1},
                    {8, 4, 2, 6},
                    {9, 1}};
    private static int startOrder = 10;
    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        System.out.println(findDigitPowerSum(18));

        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }

    private static long findDigitPowerSum(int order) {
        int current = startOrder;
        long num = A10;
        while(current != order) {
            num++;
            int sum = calculateSum(num);
            if(firstCheckNumber(num, sum) && secondCheckNumber(num, sum)) {
                current++;
                System.out.println(num);
            }
        }
        return num;
    }

    private static int calculateSum(long num) {
        int sum = 0;
        while(num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    private static boolean firstCheckNumber(long num, int sum) {
        int lastDigNum = (int) (num % 10);
        int lastDigSum = sum % 10;
        for(int i = 0; i < REMAINDERS[lastDigSum].length; i++) {
            if(lastDigNum == REMAINDERS[lastDigSum][i]) {
                return true;
            }
        }
        return false;
    }

    private static boolean secondCheckNumber(long num, int sum) {
        long res = 1;
        if(sum == 1) {
            return false;
        }
        while(res < num) {
            res *= sum;
        }
        return res == num;
    }

    private static boolean thirdCheckNumber(long num, int sum) {
        if(sum == 1) {
            return false;
        }
        int lastDigSum = sum % 10;
        while(num % sum == 0) {
            num /= sum;
            if(num % 10 == REMAINDERS[lastDigSum][0]) {
                sum = (int) Math.pow(sum, REMAINDERS[lastDigSum].length + 1);
            }
            if(num == 1) return true;
        }
        return false;
    }
}
