package main.java.problem030;

import java.util.ArrayList;
import java.util.List;

public class DigitFifthPowers {

    private static final int DEGREE = 8;
    private static int[] degreesValues;
//    private static int oneDigitDegreesMax;
    private static int oneDigitMax;
    private static int digitsMax;
    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        degreesValues = getDegreesValues();
//        oneDigitDegreesMax = (int) Math.pow(9, DEGREE);
        oneDigitMax = findOneDigitMax();
        digitsMax = findDigitsMax();

        final List<Integer> numbers = getNumbersList();
        final int sum = numbers.stream().mapToInt(i -> i.intValue()).sum();

        long end = System.currentTimeMillis();


        System.out.println("Numbers: " + numbers);
        System.out.println("Sum: " + sum);
        System.out.println("Time: " + (end - start));

        System.out.println("DEGREE: " + DEGREE);
        System.out.println("oneDigitDegreesMax: " + degreesValues[9]);
        System.out.println("oneDigitMax: " + oneDigitMax);
        System.out.println("digitsMax: " + digitsMax);

    }

    private static int[] getDegreesValues() {
        int[] values = new int[10];
        values[1] = 1;
        for(int i = 2; i < 10; i++) {

            values[i] = (int) Math.pow(i, DEGREE);

        }
        return values;
    }

    private static int findOneDigitMax() {
        int digitsCounter = degreesValues[9];
        int oneDigitMax = getDigits(digitsCounter);
        return oneDigitMax;
    }

    private static int getDigits(int digitsCounter) {
        int oneDigitMax = 0;
        while (digitsCounter > 0) {
            digitsCounter /= 10;
            oneDigitMax++;
        }
        return oneDigitMax;
    }

    private static int findDigitsMax() {
        int digits = oneDigitMax;
        int max = degreesValues[9] * digits;
        while (getDigits(max) >= digits) {
            digits++;
            max += degreesValues[9];
        }
        return --digits;
    }

    private static List<Integer> getNumbersList() {
        List<Integer> numbers = new ArrayList<>();
        final int limit = degreesValues[9] * digitsMax;
        for(int number = 2; number <= limit; number++) {
            if(checkNumber(number)) {
                numbers.add(number);
            }
        }
        return numbers;
    }

    private static boolean checkNumber(int number) {
        int val = number;
        int sum = 0;
        while(val > 0) {
            sum += degreesValues[val % 10];
            val /= 10;
        }
        return sum == number;
    }

}
