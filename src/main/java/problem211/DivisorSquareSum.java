package problem211;

import java.util.ArrayList;
import java.util.List;

public class DivisorSquareSum {

    private static final int MIN = 1;
    private static final int MAX = 1_000_000;
    private static final List<Integer> list = new ArrayList<>(MAX);

    public static void main(String[] args) {
        int count = 0;
        for(int i = MIN; i <= MAX; i++) {
            list.add(i * i);
        }
        for(Integer integer : list) {
            double num =  Math.sqrt(integer);
            double pow = num * num;
            if(pow == integer) {
                count++;
            }
        }
        System.out.println(count);
    }

}
