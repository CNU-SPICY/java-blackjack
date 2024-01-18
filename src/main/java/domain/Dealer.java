package domain;

import java.util.List;

public class Dealer {

    private String name;
    private final OwnCards ownCards = new OwnCards();

    public Dealer(String name) {
        this.name = name;
    }

    public void setFirstCards(Deck deck) {
        ownCards.getRandomTwoCards(deck);
    }

    public String getName() {
        return name;
    }

    public List<Card> getOwnCards() {
        return ownCards.getOwnCards();
    }

    public int getSumOfCards() {
        return ownCards.getSumOfCards();
    }

    public void pickCard(Deck deck) {
        ownCards.addCard(deck);
    }
}
