package problem054;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hand {

    //int[value; suit]
    private List<int[]> cards = new ArrayList<>(5);

    public List<int[]> getCards() {
        return cards;
    }

    void addCard(int[] card) {
        if(cards.isEmpty()) {
            cards.add(card);
        } else {
            int ind = 0;
            while(ind < cards.size() && card[0] < cards.get(ind)[0]) {
                ind++;
            }
            cards.add(ind, card);
        }
    }

    private String cardsToString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 5; i++) {
            int[] card = cards.get(i);
            for(int j = 0; j < 2; j++) {
                sb.append(card[j]);
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "cards: "
                + cards.toString();
    }
}
