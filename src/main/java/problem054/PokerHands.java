package problem054;

import utils.resourceReader.ResourceReader;
import utils.resourceReader.impl.ResourcesReaderImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PokerHands {

    private static final List<String> poker = new ArrayList<>();
    private static int firstScore = 0;

    public static void main(String[] args) {
        ResourceReader resourceReader = new ResourcesReaderImpl();
        poker.addAll(resourceReader.readByLines("/docks/poker.txt"));
        System.out.println(poker);
        HandsParser handsParser = new HandsParser(poker);
        List<Hand[]> hands = handsParser.parse();
        countFstScore(hands);
        System.out.println(firstScore);
    }

    private static void countFstScore(List<Hand[]> hands) {
        for (Hand[] handsPair : hands) {
            List<Integer> fstHandCalculation = HandCalculator.calculate(handsPair[0]);
            List<Integer> sndHandCalculation = HandCalculator.calculate(handsPair[1]);
            firstScore += compareHands(fstHandCalculation, sndHandCalculation);
        }
    }

    private static int compareHands(List<Integer> fstHandCalculation, List<Integer> sndHandCalculation) {
        int ind = 0;
        do {
            if(fstHandCalculation.get(ind) > sndHandCalculation.get(ind)) {
                return 1;
            } else if(fstHandCalculation.get(ind) < sndHandCalculation.get(ind)) {
                return 0;
            }
            ind++;
        } while (true);
    }
}
