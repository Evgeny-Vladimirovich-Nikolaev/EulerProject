package problem14;

import java.util.ArrayList;
import java.util.List;

public class Sequencer {

    private List<Long> maxSequence = new ArrayList<>();
    private long max;
    private long num;

    public void findLongestSequence() {
        for (int i = 1; i < 1_000_000; i++) {
            long current = i;
            long counter = 0;
            do {
                if (current % 2 == 0) {
                    current /= 2;
                } else {
                    current = current * 3 + 1;
                }
                counter++;
            } while (current != 1);
            counter++;
            if (counter > max) {
                max = counter;
                num = i;
            }
        }
    }


    public List<Long> getMaxSequence() {
        do {
            maxSequence.add(num);
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num = num * 3 + 1;
            }
        } while (num != 1);
        maxSequence.add(num);
        return maxSequence;
    }

    public long getCount() {
        return max;
    }

}
