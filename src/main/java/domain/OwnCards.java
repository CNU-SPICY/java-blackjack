package domain;

import java.util.ArrayList;
import java.util.List;

public class OwnCards {

    private final List<Card> ownCards;

    public OwnCards() {
        ownCards = new ArrayList<>();
    }

    public void getRandomTwoCards(Deck deck) {
        addCard(deck);
        addCard(deck);
    }

    public void addCard(Deck deck) {
        ownCards.add(deck.getRandomCard());
    }

    public List<Card> getOwnCards() {
        return ownCards;
    }

    public int getSumOfCards() {
        return ownCards.stream().mapToInt(Card::getCardRank).sum();
    }
}
