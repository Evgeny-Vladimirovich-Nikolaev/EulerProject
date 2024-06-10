package main.java.problem009;

public class SpecialPythagoreanTriplet {

    private static final int SUM = 1000;

    public static void main(String[] args) {
        System.out.println(findPythagoreanTriplet());
    }

    private static int findPythagoreanTriplet() {
        for (int a = 1; a < SUM / 2; a++) {
            for (int b = a + 1; b < SUM / 2; b++) {
                int c = 1000 - a - b;
                if (a + b + c == SUM && Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)) {
                    return a * b * c;
                }
            }
        }
        return -1;
    }
}
