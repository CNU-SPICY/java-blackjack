package blackjack.domain;

import java.util.ArrayList;

public class Dealer {
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

    public boolean isHitPossible() {
        return (calculateTotalScore() < GameConstant.DEALER_STAND_SCORE);
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

    public ArrayList<Card> getHand() {
        return hand;
    }
}