package problem044;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.UnaryOperator;

public class PentagonNumbers {

    private static final List<Integer> numbers = new ArrayList<>();
    private static final Map<Integer, int[]> pair = new TreeMap<>();
    private static int minDiff = 30_000;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        fillNumbers(integer -> integer * (3 * integer - 1) / 2);
        long end = System.currentTimeMillis();
        System.out.println(minDiff);
        System.out.println((end - start) / 60_000 + "min " + ((end - start) % 60_000) / 1000 + "sec");

    }

    private static void fillNumbers(UnaryOperator<Integer> pentagon) {
        int n = 1;
        numbers.add(pentagon.apply(n++));
        numbers.add(pentagon.apply(n++));
        while (checkDifference()) {
            numbers.add(pentagon.apply(n++));
            findNewDiff();
//            if(pair.size() % 300 == 0) {
//                System.out.println(pair);
//            }
        }
    }

    private static boolean checkDifference() {
        return numbers.getLast() - numbers.get(numbers.size() - 2) < minDiff;
    }

    private static void findNewDiff() {
        for (int i = numbers.size() - 2; i > 0; i--) {
                int diff = numbers.getLast() - numbers.get(i);
                if (numbers.contains(diff)) {
                    pair.putIfAbsent(diff, new int[]{numbers.get(i), numbers.getLast()});
                }

        }
    }

}
