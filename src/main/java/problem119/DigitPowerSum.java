package problem119;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DigitPowerSum {

    private static final long MAX = Long.MAX_VALUE / 1000;
    private static final List<Long> numbsList = new ArrayList<>();

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        fillNumbsList();
        Collections.sort(numbsList);
        long end = System.currentTimeMillis();
        System.out.println(numbsList.get(29));
        System.out.println(end - start);

     }

    private static void fillNumbsList() {
        for (int i = 2; i < 1000; i++) {
            long j = i;
            while (j < MAX) {
                j *= i;
                if (checkNum(j, i)) {
                    numbsList.add(j);
                }
            }
        }
    }

    private static boolean checkNum(long j, int i) {
        int res = 0;
        while (j > 0) {
            res += j % 10;
            j /= 10;
        }
        return res == i;
    }

}

