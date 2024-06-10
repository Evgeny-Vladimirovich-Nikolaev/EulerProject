package main.java.problem005;

public class SmallestMultiple {

private static final int NUMBER = 20;
private static final int[] DIVISORS = new int[NUMBER + 1];

    public static void main(String[] args) {
        int result = effectiveSolution();
        System.out.println(result);
    }

    private static int effectiveSolution() {
        int result = 1;
        for (int num = 2; num < DIVISORS.length; num++) {
            int current = num;
            for(int ind = 2; ind <= num; ind++) {
                int count = 0;
                while(current % ind == 0) {
                    current /= ind;
                    count++;
                }
                if(DIVISORS[ind] < count) {
                    DIVISORS[ind] = count;
                }
            }
        }
        for(int ind = 2; ind < DIVISORS.length; ind++) {
            if(DIVISORS[ind] != 0) {
                result *= Math.pow(ind, DIVISORS[ind]);
            }
        }
        return result;
    }

}
