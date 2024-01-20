package blackjack.domain.card;

import blackjack.domain.enums.CardNumber;
import blackjack.domain.enums.CardType;

public class Card {

    private final CardType cardType;
    private final CardNumber cardNumber;

    public Card(CardType cardType, CardNumber cardNumber) {
        this.cardType = cardType;
        this.cardNumber = cardNumber;
    }

    public String getCardTypeName() {
        return cardType.getName();
    }

    public CardNumber getCardNumber() {
        return cardNumber;
    }

    public String getCardNumberName() {
        return cardNumber.getName();
    }

    public int getScore() {
        return cardNumber.getScore();
    }
}
