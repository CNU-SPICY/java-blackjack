package blackjack.domain.person;

import blackjack.domain.card.Card;
import blackjack.domain.card.Deck;
import blackjack.domain.GameConstant;
import java.util.ArrayList;

public class Person {
    private final ArrayList<Card> hand = new ArrayList<>();

    public void initDeal(Deck deck) {
        drawCard(deck);
        drawCard(deck);
    }

    public void drawCard(Deck deck) {
        addCardToHand(deck.drawRandomCard());
    }

    public void addCardToHand(Card card) {
        hand.add(card);
    }

    public boolean isHitPossible(int score) {
        return (calculateTotalScore() < score);
    }

    public int calculateTotalScore() {
        int totalScore = hand.stream()
                .mapToInt(Card::getScore)
                .sum();
        long aceCount = countAce();
        while(aceCount > 0 && totalScore >= GameConstant.BUST_SCORE) {
            totalScore -= GameConstant.ACE_EXTRA_SCORE;
            aceCount --;
        }
        return totalScore;
    }

    private long countAce() {
        return hand.stream()
                .filter(this::isAce)
                .count();
    }

    private boolean isAce(Card card) {
        return card.getDenomination().equals("A");
    }

    public boolean isBlackjack() {
        boolean score = (calculateTotalScore() == GameConstant.BLACKJACK_SCORE);
        boolean count = (hand.size() == 2);
        return (score && count);
    }

    public ArrayList<Card> getHand() {
        return hand;
    }
}