package domain;

import java.util.ArrayList;
import java.util.List;

public class OwnCards {

    private final List<Card> ownCards;

    public OwnCards() {
        ownCards = new ArrayList<>();
    }

    public void getRandomTwoCards(Deck deck) {
        addCard(deck.getRandomCard());
        addCard(deck.getRandomCard());
    }

    public void addCard(Card card) {
        ownCards.add(card);
    }

    public List<Card> getOwnCards() {
        return ownCards;
    }
}
