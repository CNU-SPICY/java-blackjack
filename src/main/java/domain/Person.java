package domain;

public class Person {

    private String name;
    private OwnCards ownCards;

    public Person(String name) {
        this.name = name;
        getFirstTwoCards();
    }

    private void getFirstTwoCards() {
        ownCards.addCard(Deck.getRandomCard());
        ownCards.addCard(Deck.getRandomCard());
    }
}
