package domain;

import java.util.List;

public class Person {

    private String name;
    private final OwnCards ownCards = new OwnCards();

    public Person(String name) {
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
