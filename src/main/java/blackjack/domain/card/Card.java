package blackjack.domain.card;

public class Card {
    private final CardData.Suit suit;
    private final CardData.Denomination denomination;

    public Card(CardData.Suit suit, CardData.Denomination denomination) {
        this.suit = suit;
        this.denomination = denomination;
    }

    public String getSuit() {
        return suit.getSuit();
    }

    public String getDenomination() {
        return denomination.getDenomination();
    }

    public int getScore() {
        return denomination.getScore();
    }
}