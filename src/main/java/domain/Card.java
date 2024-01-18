package domain;

public class Card {

    private String cardShape;
    private String cardRank;

    public Card(String cardShape, String cardRank) {
        this.cardShape = cardShape;
        this.cardRank = cardRank;
    }

    public String getCardFullName() {
        return this.cardRank + this.cardShape;
    }

    public String getCardRank() {
        return cardRank;
    }
}
