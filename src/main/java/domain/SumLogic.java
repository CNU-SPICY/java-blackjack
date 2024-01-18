package domain;

import java.util.List;

public class SumLogic {

    private static final int MIN_ACE_VALUE = 1;
    private static final int MAX_ACE_VALUE = 11;
    private static final int STANDARD_NUMBER = 21;

    public int applyLogic(List<Card> ownCards) {
        int sum = 0;
        for (Card card : ownCards) {
            sum += handleAllCase(card, sum);
        }
        return sum;
    }

    public int handleAllCase(Card card, int sum) {
        if (card.getCardRank().equals("A")) {
            return aceCheck(card, sum);
        }
        if (card.getCardRank().equals("J") || card.getCardRank().equals("Q") || card.getCardRank().equals("K")) {
            return 10;
        }
        return Integer.parseInt(card.getCardRank());
    }

    private int aceCheck(Card card, int sum) {
        if (MAX_ACE_VALUE + sum > STANDARD_NUMBER) {
            return MIN_ACE_VALUE;
        }
        return MAX_ACE_VALUE;
    }
}
