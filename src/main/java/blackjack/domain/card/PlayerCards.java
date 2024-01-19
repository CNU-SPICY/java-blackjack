package blackjack.domain.card;

import blackjack.domain.enums.CardNumber;
import java.util.ArrayList;
import java.util.List;

public class PlayerCards {

    public static final int DEAD_LINE = 21;

    private final List<Card> cards;

    public PlayerCards() {
        this.cards = new ArrayList<>();
    }

    public void pickCard(Card card) {
        cards.add(card);
    }

    public int calcScore() {
        final int score = cards.stream().mapToInt(Card::getNumber).sum();
        final int extra = extraScoreFromAce(score);
        return score + extra;
    }

    private int extraScoreFromAce(int score) {
        return AmountOfAceWithExtraScore(score) * CardNumber.DIFF_ACE_SCORE;
    }

    private int AmountOfAceWithExtraScore(int score) {
        int upperAmountOfAce = AmountOfAce();
        int extraAmountOfAce = (DEAD_LINE - score) / CardNumber.DIFF_ACE_SCORE;
        return Math.min(upperAmountOfAce, extraAmountOfAce);
    }

    private int AmountOfAce() {
        return (int) cards.stream().filter(card -> card.getCardNumber() == CardNumber.ACE).count();
    }

    public List<Card> getCards() {
        return cards;
    }
}
