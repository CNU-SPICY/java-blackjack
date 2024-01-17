package blackjack.domain;

public class Card {
    private final String suit;
    private final int score;

    public Card(String suit, int score) {
        this.suit = suit;
        this.score = score;
    }

    public String getSuit() {
        return suit;
    }

    public int getScore() {
        return score;
    }
}
