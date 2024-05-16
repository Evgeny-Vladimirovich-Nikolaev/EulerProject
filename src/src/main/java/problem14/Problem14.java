package problem14;

public class Problem14 {

    public static void main(String[] args) {
        Sequencer sequencer = new Sequencer();
        sequencer.findLongestSequence();
        System.out.println(sequencer.getCount());
        System.out.println(sequencer.getMaxSequence());
    }

}
