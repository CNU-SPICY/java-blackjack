package blackjack.domain;

import java.util.ArrayList;

public class Player {
    private final String name;
    private ArrayList<String> hand;
    private int score;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.score = 0;
    }

    public String getPlayerName() {
        return name;
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