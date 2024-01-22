package blackjack.domain.card;

import java.util.ArrayList;
import java.util.List;

public class PlayerCards {

    public static final int DEAD_LINE = 21;

    private final List<Card> cards;

    public PlayerCards() {
        this.cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int calcScore() {
        final int score = cards.stream().mapToInt(Card::getScore).sum();
        final int extra = extraScoreFromAce(score);
        return score + extra;
    }

    private int extraScoreFromAce(int score) {
        return amountOfAceWithExtraScore(score) * CardNumber.DIFF_ACE_SCORE;
    }

    private int amountOfAceWithExtraScore(int score) {
        int upperAmountOfAce = amountOfAce();
        int extraAmountOfAce = (DEAD_LINE - score) / CardNumber.DIFF_ACE_SCORE;
        return Math.min(upperAmountOfAce, extraAmountOfAce);
    }

    private int amountOfAce() {
        return (int) cards.stream().filter(card -> card.getCardNumber() == CardNumber.ACE).count();
    }

    public int getCardsAmount() {
        return cards.size();
    }

    public List<Card> getCards() {
        return cards;
    }
}