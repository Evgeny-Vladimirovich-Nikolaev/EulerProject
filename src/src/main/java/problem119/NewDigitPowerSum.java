package problem119;

import java.util.Map;
import java.util.TreeMap;

public class NewDigitPowerSum {

    private static final long A10 = 79;
    private static int startOrder = 0;
    private static final long MAX = Long.MAX_VALUE / 1_000_000;
    private static Map<Long, Integer> map = new TreeMap<>();

    public static void main(String[] args) {
        
        long start = System.currentTimeMillis();
            fillTree();
        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }

    private static void fillTree() {
        for(int i = 7; i < 100; i++) {
            System.out.println(i);
            long j = i;
            while (j < MAX) {
                j *= j;
                if(checkNum(j, i)) {
                    map.put(j, i);
                    startOrder++;
                    System.out.println(startOrder + ": " + j);
                }
            }
        }
    }

    private static boolean checkNum(long j, int i) {
        int res = 0;
        while (j > 0) {
            res += j % 10;
            j /=10;
        }
        return res == i;
    }

}

