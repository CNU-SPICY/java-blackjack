package blackjack.domain;

public class Card {
    private final String info;
    private final int score;

    public Card(String info, int score) {
        this.info = info;
        this.score = score;
    }

    public String getInfo() {
        return info;
    }

    public int getScore() {
        return score;
    }
}
