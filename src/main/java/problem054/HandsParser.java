package problem054;

import java.util.ArrayList;
import java.util.List;

public class HandsParser {

    private final List<String> poker;

    public HandsParser(List<String> poker) {
        this.poker = poker;
    }

    public List<Hand[]> parse() {
        List<Hand[]> handsPairs = new ArrayList<>();
        fillHandsPairs(handsPairs);
        return handsPairs;
    }



    private void fillHandsPairs(List<Hand[]> handsPairs) {
        for(String line : poker) {
            Hand[] pair = parseLine(line);
            handsPairs.add(pair);
        }
    }

    private Hand[] parseLine(String line) {
        Hand[] pair = new Hand[2];
        Hand fstHand = parseHand(line.substring(0, 14));
        Hand sndHand = parseHand(line.substring(15, 29));
        pair[0] = fstHand;
        pair[1] = sndHand;
        return pair;
    }

    private Hand parseHand(String substring) {
        Hand hand = new Hand();
        String s = substring.replaceAll("\\s+","");
        for(int i = 0; i < 10; i++) {
            int[] card = new int[2];
            card[0] = convertSymbolToInt(s.charAt(i));
            card[1] = convertSymbolToInt(s.charAt(++i));
            hand.addCard(card);
        }
        return hand;
    }

    private int convertSymbolToInt(char ch) {
        return switch (ch) {
            case '2', 'C' -> 2;
            case '3', 'D' -> 3;
            case '4', 'H' -> 4;
            case '5' -> 5;
            case '6' -> 6;
            case '7' -> 7;
            case '8' -> 8;
            case '9' -> 9;
            case 'T' -> 10;
            case 'J' -> 11;
            case 'Q' -> 12;
            case 'K' -> 13;
            case 'A' -> 14;
            case 'S' -> 1;
            default -> throw new IllegalStateException("Unexpected value: " + ch);
        };
    }

}
