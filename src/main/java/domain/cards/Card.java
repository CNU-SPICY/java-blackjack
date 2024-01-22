package domain.cards;

import domain.cards.constant.CardEnums.CardRank;
import domain.cards.constant.CardEnums.CardSuit;

public class Card {

    private CardSuit cardSuit;
    private CardRank cardRank;

    public Card(CardSuit cardSuit, CardRank cardRank) {
        this.cardSuit = cardSuit;
        this.cardRank = cardRank;
    }

    public String getCardFullName() {
        return this.cardRank.getRankName() + this.cardSuit.getSuitName();
    }

    public String getCardRank() {
        return cardRank.getRankName();
    }

    public String getCardSuit() {
        return cardSuit.getSuitName();
    }
}
