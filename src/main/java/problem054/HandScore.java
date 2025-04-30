package problem054;

public class HandScore {
    private final int highestValue;
    private final int[] set;

    public HandScore(int highestValue, int rank, int fstCard, int sndCard, int thdCard, int fthCard, int fvCard) {
        this.highestValue = highestValue;
        set = new int[6];
        set[0] = rank;
        set[1] = fstCard;
        set[2] = sndCard;
        set[3] = thdCard;
        set[4] = fthCard;
        set[5] = fvCard;
    }

    public int getHighestValue() {
        return highestValue;
    }

    public int[] getSet() {
        return set;
    }
}
