package blackjack.domain;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private final ArrayList<Card> deck = new ArrayList<>();

    public void initDeck() {
        for (CardData.Suit suit : CardData.Suit.values()) {
            for (CardData.Denomination denomination: CardData.Denomination.values()) {
                deck.add(new Card(suit, denomination));
            }
        }
        Collections.shuffle(deck);
    }
    public Card drawRandomCard() {
        return deck.remove(0);
    }
}
