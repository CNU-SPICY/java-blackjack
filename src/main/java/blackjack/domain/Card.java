package blackjack.domain;

import blackjack.domain.carddata.CardNumber;
import blackjack.domain.carddata.CardType;

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

    public int getNumber() {
        return cardNumber.getNumber();
    }
}
