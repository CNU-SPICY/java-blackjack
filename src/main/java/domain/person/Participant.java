package domain.person;

import domain.cards.Deck;
import domain.cards.OwnCards;
import domain.logics.Score;
import domain.person.wrapper.ParticipantName;
import dto.CardDto;
import java.util.List;

public class Participant {

    protected final OwnCards ownCards;

    private final ParticipantName name;

    private final Score score;

    protected Participant(final String name) {
        this.name = ParticipantName.create(name);
        this.ownCards = OwnCards.create();
        this.score = Score.create();
    }

    static Participant create(final String name) {
        return new Participant(name);
    }

    public void setFirstCards(Deck deck) {
        ownCards.getRandomTwoCards(deck);
    }

    public void pickCard(Deck deck) {
        ownCards.addCard(deck);
    }

    public List<CardDto> getOwnCardsRankAndSuit() {
        return ownCards.getRankAndSuit();
    }

    public int getSumOfCards() {
        return ownCards.getSumOfCards();
    }

    public void increaseWinCount() {
        score.increaseWinCount();
    }

    public void increaseDrawCount() {
        score.increaseDrawCount();
    }

    public void increaseLoseCount() {
        score.increaseLoseCout();
    }

    public int getBattleResult() {
        if (score.getWinCount() == 1) {
            return 1;
        }
        if (score.getLoseCount() == 1) {
            return -1;
        }
        return 0;
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
