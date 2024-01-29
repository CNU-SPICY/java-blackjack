package domain.logics;

import domain.cards.Card;
import java.util.List;

public class ScoreLogic {

    private static final int MIN_ACE_VALUE = 1;
    private static final int MAX_ACE_VALUE = 11;
    private static final int STANDARD_NUMBER = 21;

    public int applyLogic(List<Card> ownCards) {
        int sum = 0;
        int numberOfAces = 0;
        for (Card card : ownCards) {
            numberOfAces = checkIfAceCard(card, numberOfAces);
            sum += handleAllCase(card);
        }
        sum = handleRemainAceCards(numberOfAces, sum);
        return sum;
    }

    private int checkIfAceCard(Card card, int numberOfAces) {
        if (card.getCardRank().equals("A")) {
            return ++numberOfAces;
        }
        return numberOfAces;
    }

    public int handleAllCase(Card card) {
        if (card.getCardRank().equals("A")) {
            return 0;
        }
        if (card.getCardRank().equals("J") || card.getCardRank().equals("Q") || card.getCardRank().equals("K")) {
            return 10;
        }
        return Integer.parseInt(card.getCardRank());
    }

    private int handleRemainAceCards(int numberOfAces, int sum) {
        int remainNumber = STANDARD_NUMBER - sum;
        int aceIsOne = numberOfAces * MIN_ACE_VALUE;
        int aceIsEleven = 0;
        if (remainNumber < 0) {
            return sum + aceIsOne + aceIsEleven;
        }
        while (remainNumber > 0) {
            remainNumber = STANDARD_NUMBER - sum;
            remainNumber -= (aceIsOne + aceIsEleven);
            if (remainNumber == 0) {
                continue;
            }
            if (remainNumber <= 0 && aceIsOne != numberOfAces * MIN_ACE_VALUE) {
                aceIsOne += MIN_ACE_VALUE;
                aceIsEleven -= MAX_ACE_VALUE;
                continue;
            }
            if (remainNumber <= 0) {
                continue;
            }
            if (aceIsOne == 0) {
                break;
            }
            aceIsOne -= MIN_ACE_VALUE;
            aceIsEleven += MAX_ACE_VALUE;
        }
        return sum + aceIsOne + aceIsEleven;
    }

    public boolean isBust(int sumOfCards) {
        return sumOfCards > STANDARD_NUMBER;
    }

    public boolean isBlackJack(int sumOfCards) {
        return sumOfCards == STANDARD_NUMBER;
    }
}
