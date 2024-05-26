package problem003;

public class LargestSimpleDivisor {

    private static final long NUMBER = 600851475143L;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long currentMax = NUMBER;
        for(int i = 2; i <= Integer.MAX_VALUE; i++) {
            if(i >= currentMax) {
                break;
            }
            while (currentMax % i == 0) {
                currentMax /= i;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(currentMax);
        System.out.println(end - start);
    }

}
