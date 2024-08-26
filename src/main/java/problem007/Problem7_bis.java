package problem007;

public class Problem7_bis {

    private static byte[] primes = new byte[1_000_000];

    Iterable<Object> iterable;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        primes[0] = primes[1] = 1;
        int multiplier1 = 2;
        int multiplier2 = 2;
        for (;multiplier1 * multiplier2 < primes.length;) {
            if(primes[multiplier1] != 0) {
                multiplier2 = ++multiplier1;
                continue;
            }
            while(multiplier1 * multiplier2 < primes.length)
            {
                primes[multiplier1 * multiplier2++] = 1;
            }
            multiplier2 = ++multiplier1;
        }
        int count = 0;
        int i = 0;
        for(; i < primes.length - 1 && count != 10001; i++) {
            if(primes[i] == 0 && ++count == 10001) {
                break;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(i);
        System.out.println(end - start);
    }
}
