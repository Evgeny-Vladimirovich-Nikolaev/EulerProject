package problem054;

import java.util.ArrayList;
import java.util.List;

public class HandCalculator {

    private static final int HIGH_CARD = 1;
    private static final int ONE_PAIR = 2;
    private static final int TWO_PAIRS = 3;
    private static final int THREE_OF_A_KIND = 4;
    private static final int STRAIGHT = 5;
    private static final int FLUSH = 6;
    private static final int FULL_HOUSE = 7;
    private static final int FOUR_OF_A_KIND = 8;
    private static final int STRAIGHT_FLUSH = 9;
    private static final int ROYAL_FLUSH = 10;
    private static final int ACE = 14;


    private static boolean isRanked;
    private static List<Integer> handCalculation;
    private static List<int[]> cards;

    private HandCalculator() {
    }

    public static List<Integer> calculate(Hand hand) {
        isRanked = false;
        HandCalculator.cards = hand.getCards();
        handCalculation = new ArrayList<>(6);
        defineRank();
        return handCalculation;
    }

    private static void defineRank() {
        checkSameValue();
        if (!isRanked) {
            addRank();
        }
    }

    private static void addRank() {
        int rank = HIGH_CARD;
        if (isStraight()) {
            rank = STRAIGHT;
        }
        if (isFlush()) {
            rank = FLUSH;
        }
        if (isStraight() && isFlush()) {
            rank = STRAIGHT_FLUSH;
            if (isRoyalFlush()) {
                rank = ROYAL_FLUSH;
            }
        }
        handCalculation.add(0, rank);
    }

    private static void checkSameValue() {
        int fstSet = 1;
        int sndSet = 1;
        int fstHighest = 0;
        int sndHighest = 0;
        int ind = 0;
        handCalculation.add(cards.get(ind++)[0]);
        while (ind < 5) {
            if (cards.get(ind)[0] == cards.get(ind - 1)[0]) {
                fstSet++;
                fstHighest = cards.get(ind)[0];
                ind++;
                isRanked = true;
            } else {
                handCalculation.add(cards.get(ind)[0]);
                ind++;
                if (fstSet > 1) {
                    break;
                }
            }
        }
        while (ind < 5) {
            if (cards.get(ind)[0] == cards.get(ind - 1)[0]) {
                sndSet++;
                sndHighest = cards.get(ind)[0];
            } else {
                handCalculation.add(cards.get(ind)[0]);
            }
            ind++;
        }
        if (handCalculation.contains(sndHighest)) {
            handCalculation.remove(handCalculation.indexOf(sndHighest));
            handCalculation.add(0, sndHighest);
        }
        if (handCalculation.contains(fstHighest)) {
            handCalculation.remove(handCalculation.indexOf(fstHighest));
            handCalculation.add(0, fstHighest);
        }

        if (fstSet > 1) {
            if (sndSet == 1) {
                if (fstSet == 2) {
                    handCalculation.add(0, ONE_PAIR);
                } else if (fstSet == 3) {
                    handCalculation.add(0, THREE_OF_A_KIND);
                } else {
                    handCalculation.add(0, FOUR_OF_A_KIND);
                }
            } else if (fstSet == sndSet) {
                handCalculation.add(0, TWO_PAIRS);
            } else {
                if (fstSet < sndSet) {
                    int value = handCalculation.remove(1);
                    handCalculation.add(0, value);
                }
                handCalculation.add(0, FULL_HOUSE);
            }
        }
    }

    private static boolean isStraight() {
        for (int ind = 0; ind < 4; ind++) {
            if (!(cards.get(ind)[0] == cards.get(ind + 1)[0] + 1)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isFlush() {
        for (int ind = 0; ind < 4; ind++) {
            if (!(cards.get(ind)[1] == cards.get(ind + 1)[1])) {
                return false;
            }
        }
        return true;
    }

    private static boolean isRoyalFlush() {
        return cards.get(0)[0] == ACE;
    }

}
