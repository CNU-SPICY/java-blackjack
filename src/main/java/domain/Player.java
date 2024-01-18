package domain;

import java.util.List;

public class Player {

    private final OwnCards ownCards = new OwnCards();
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public void firstCardSetting(Deck deck) {
        ownCards.getRandomTwoCards(deck);
    }

    public String getName() {
        return name;
    }

    public List<Card> getOwnCards() {
        return ownCards.getOwnCards();
    }
}
