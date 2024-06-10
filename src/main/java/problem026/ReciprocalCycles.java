package main.java.problem026;

import java.math.BigInteger;

public class ReciprocalCycles {

    public static final int SIZE = 1000;
    public static final long MULTIPLIER = 1_000_000_000_000_000_000L;
    public static final boolean[] COMPLEX_NUMBERS = new boolean[SIZE];
    private static BigInteger divisible = BigInteger.valueOf(MULTIPLIER);

    private static int maxLength = 0;
    private static int maxCycleNumber = 0;
    private static String maxSequence;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        fillComplexNumbers();
        findMaxLength();
        long end = System.currentTimeMillis();

        System.out.println("maxCycleNumber: " + maxCycleNumber);
        System.out.println("maxLength: " + maxLength);
        System.out.println("maxSequence: " + maxSequence);
        System.out.println("time: " + (end - start));

    }

    private static void fillComplexNumbers() {
        for(int index = 2; index * index < SIZE; index++) {
            if(!COMPLEX_NUMBERS[index]) {
                int multiplier = index;
                while (multiplier * index < SIZE) {
                    COMPLEX_NUMBERS[multiplier * index] = true;
                    multiplier++;
                }
            }
        }
    }

    private static void findMaxLength() {
        for(int index = 7; index < SIZE; index++) {
            if (!COMPLEX_NUMBERS[index]) {
                String val = divisible.divide(BigInteger.valueOf(index)).toString();
                int length = 1;
                while(true) {
                    if(length > val.length() / 3) {
                        divisible = divisible.multiply(BigInteger.valueOf(MULTIPLIER));
                        val = divisible.divide(BigInteger.valueOf(index)).toString();
                    }
                    String substr = val.substring(0, length + 1);
                    String substr2 = val.substring(length + 1, length * 2 + 2);
                    length++;
                    if(substr.equals(substr2)) {
                        if(length > maxLength) {
                            maxLength = length;
                            maxCycleNumber = index;
                            maxSequence = substr;
                        }
                        break;
                    }
                }

            }
        }
    }

}
