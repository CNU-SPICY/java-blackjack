package domain.person;

import domain.cards.Card;
import domain.cards.OwnCards;
import domain.person.wrapper.ParticipantName;
import dto.CardDto;
import java.util.List;

public class Participant {

    protected final OwnCards ownCards;

    private final ParticipantName name;

    protected Participant(final String name) {
        this.name = ParticipantName.create(name);
        this.ownCards = OwnCards.create();
    }

    static Participant create(final String name) {
        return new Participant(name);
    }

    public void setFirstCards(Card firstCard, Card secondCard) {
        ownCards.getRandomTwoCards(firstCard, secondCard);
    }

    public void pickCard(Card card) {
        ownCards.addCard(card);
    }

    public List<CardDto> getOwnCardsRankAndSuit() {
        return ownCards.getRankAndSuit();
    }

    public int getSumOfCards() {
        return ownCards.getSumOfCards();
    }

    public boolean isBust() {
        return ownCards.isBust();
    }

    public boolean isBlackJack() {
        return ownCards.isBlackJack();
    }

    public String getName() {
        return name.getName();
    }
}
