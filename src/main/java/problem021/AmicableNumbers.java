package main.java.problem021;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class AmicableNumbers {



    private Map<Integer,Integer> pairNumberSum = new ConcurrentHashMap<>();
    private  int amicableNumbersSum = 0;
    private  int limit = 10_000;

    public int getAmicableNumbersSum() {
        return amicableNumbersSum;
    }

    public AmicableNumbers() {
        fillMap();
        calculateSum();
    }

    private  void fillMap() {
        for(int key = 1; key < limit; key++) {
            int divisorsSum = 1;
            for(int div = 2, max = key; div < max; div++) {
                if(key % div == 0) {
                    max = key / div;
                    divisorsSum += div;
                    if (max != div) {
                        divisorsSum += max;
                    }
                }
            }
            pairNumberSum.put(key, divisorsSum);
        }
    }

    private  void calculateSum() {
        for(Map.Entry<Integer, Integer> entry : pairNumberSum.entrySet()) {
            int value = entry.getValue();
            int key = entry.getKey();
            if(value > key && value < limit && pairNumberSum.get(value) == key) {
                amicableNumbersSum += (key + value);
                pairNumberSum.remove(value);
            }
        }
    }

}
