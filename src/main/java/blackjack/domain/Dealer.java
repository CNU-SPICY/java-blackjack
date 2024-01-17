package blackjack.domain;

import java.util.ArrayList;

public class Dealer {
    private ArrayList<String> hand;
    private int score;

    public Dealer(String name) {
        this.hand = new ArrayList<>();
        this.score = 0;
    }

    public ArrayList<String> getHand() {
        return hand;
    }

    public int getScoreSum() {
        return score;
    }

    public void addCardToHand(Card card) {
        String cardSuit = card.getSuit();
        int cardScore = card.getScore();
        hand.add(cardSuit);
        score += cardScore;
    }
}
