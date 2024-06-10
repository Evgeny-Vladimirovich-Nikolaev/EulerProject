package main.java.problem006;

public class SumSquareDifference {

    public static void main(String[] args) {
        int sum = 0;
        int sumSquares = 0;
        int squareSum;
        int difference;
        for(int i = 1; i <= 100; i++) {
            sum += i;
            sumSquares += (int) Math.pow(i, 2);
        }
        squareSum = (int) Math.pow(sum, 2);
        difference = squareSum - sumSquares;
        System.out.println(difference);
        System.out.println((long)Math.pow(9, 13));
    }

}
