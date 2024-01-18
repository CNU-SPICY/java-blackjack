package blackjack.domain;

import blackjack.domain.carddata.CardNumber;
import blackjack.domain.carddata.CardType;
import java.util.ArrayList;
import java.util.List;

public class Deck {

    private final List<Card> deck;

    public Deck() {
        this.deck = new ArrayList<>();
        initDeck();
    }

    public Card popCard(int index) {
        return deck.remove(index);
    }

    public int getSizeOfDeck() {
        return deck.size();
    }

    private void initDeck() {
        for (CardType cardType : CardType.values()) {
            for (CardNumber cardNumber : CardNumber.values()) {
                deck.add(new Card(cardType, cardNumber));
            }
        }
    }
}
