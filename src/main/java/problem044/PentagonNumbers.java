package problem044;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PentagonNumbers {

    private static List<Integer> pentagonalNumbers = new ArrayList<>(1000);
    private static Map<Integer, Integer> differences = new TreeMap<>();
    public static void main(String[] args) {

        int sum = findPentagonalSum();
        System.out.println(differences.get(sum));
        System.out.println(pentagonalNumbers.size());
    }

    private static int findPentagonalSum() {
        int next;
        int currentDiff = 4;
        pentagonalNumbers.add(1);
        do {
            int previous = pentagonalNumbers.get(pentagonalNumbers.size() - 1);
            next = previous + currentDiff;
            pentagonalNumbers.add(next);
            findDifferences();
            currentDiff += 3;
        } while(!differences.containsKey(next));
        return next;
    }

    private static void findDifferences() {
        int last = pentagonalNumbers.get(pentagonalNumbers.size() - 1);
        for(int i = 0; i < pentagonalNumbers.size() - 1; i++) {
            int diff = last - pentagonalNumbers.get(i);
            if(pentagonalNumbers.contains(diff)) {
                differences.put(last + pentagonalNumbers.get(i), diff);
            }
        }
    }

}
