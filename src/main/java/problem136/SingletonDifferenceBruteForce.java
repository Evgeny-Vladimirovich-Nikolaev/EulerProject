package main.java.problem136;

public class SingletonDifferenceBruteForce {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long end = start;
        int commonCount = 0;
        long number = 1;
        final int max = Integer.MAX_VALUE - 2;
        final int maxJ = Integer.MAX_VALUE / 2;
        while (number < 100L) {
            int localCount = 0;
            for (int i = 0; i < max; i++) {
                long res = 0;
                for (int j = 1; j < maxJ; j++) {
                    if (Integer.MAX_VALUE - i < j * 2) {
                        break;
                    }
                    long x = (long) i + 2L * (long) j;
                    long y = (long) i + (long) j;
                    long z = i;
                    res = x * x - y * y - z * z;
                    if(res > number) {
                        break;
                    }
                    if (res == number) {
                        localCount++;
                        end = System.currentTimeMillis();
                        System.out.println(
                                        x
                                        + "^2 - "
                                        + y
                                        + "^2 - "
                                        + z
                                        + "^2"
                                        + " = "
                                        + number
                                        + " (" + (end - start) / 1000 + ")");
                    }
                    if (localCount > 1) {
                        break;
                    }
                }
                if(localCount > 1 || res > Math.pow(number, 4)) {
                    break;
                }
            }
            if(localCount == 1) {
                commonCount++;
            }
            number++;
        }
        System.out.println("Finish: " + commonCount + " " + (end - start));
    }

}
